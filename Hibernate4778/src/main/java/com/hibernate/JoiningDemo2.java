package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

public class JoiningDemo2 {
	public static void main(String[] args) {
		
		try(SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				Session session=factory.openSession())
		{
			
			Transaction tx=session.beginTransaction();
			/*
			Author author1= new Author();
			author1.setAId(211);
			author1.setName("APJ Abdul Kalam");
			
			Book book1=new Book();
			book1.setBookName("Wings of Fire");
			book1.setBookPages(280);
			book1.setBookPrice(220);
			book1.setAuthor(author1);
			
			Book book2=new Book();
			book2.setBookName("Ignited Mind");
			book2.setBookPages(160);
			book2.setBookPrice(120);
			book2.setAuthor(author1);
			
			//array list to store the book
			List<Book> books=new ArrayList<Book>();
			books.add(book1);
			books.add(book2);
			
			//adding all books in the list created in author class
			author1.setBooks(books);
			
			session.save(author1);
			session.save(book1);
			session.save(book2);
			
			//fetch book and author details
			Author auth=session.get(Author.class, 211);
			System.out.println("Author Name:"+auth.getName());
			
			System.out.println();
			System.out.println("Book Details:");
			for(Book b:auth.getBooks())
			{
				System.out.println("Book Name:"+b.getBookName());
				System.out.println("Book Price:"+b.getBookPrice());
		}
			*/
			
			//using HQl
			String hql ="from Book where bookName=:name and bookPrice=:price"; //select * from book_info;
			Query q=session.createQuery(hql);
			
			q.setParameter("name", "Wings of Fire");
			q.setParameter("price",350.0);
			
			List<Book> list=q.getResultList();
			
			for(Book book:list)
			{
				System.out.println(book.getBookName());
				System.out.println(book.getAuthor().getName());
			}
			
			//delete query
			//string query= "delete from Book where bookName=:n";
			Query q1=session.createQuery("delete from Book where bookName=:n");
			
			q1.setParameter("n", "Ignited Mind");
			
			int r=q1.executeUpdate();
			System.out.println(r+"row deleted sucessfully");
			tx.commit();
			
			//delete query way 2
			Book b1=session.get(Book.class, 3);
			session.delete(b1);
			tx.commit();
			
			//update query
			Query q2=session.createQuery("update Book set bookName=:n, bookPrice=:p, bookPages=:b where bookId=:id");
			q2.setParameter("n", "Mocking Bird");
			q2.setParameter("p", 249.9);
			q2.setParameter("b", 300);
			q2.setParameter("id", 1);
			
			int r1=q2.executeUpdate();
			System.out.println(r1+"row updated sucessfully");
			tx.commit();
			
		
		//using named query
		Query q3=session.getNamedQuery("byBookName");
		q3.setString(1, "Mocking Bird");
		List<Book> l = q3.list();
		for(Book b:l)
		{
			System.out.println(b);
		}
		}		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
