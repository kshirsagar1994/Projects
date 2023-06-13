package com.hibernate;

import org.hibernate.HibernateException;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class joiningDemo {
	
	public static void main(String[] args)
	{
		try(SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session=factory.openSession())
		
		{
		Transaction tx=session.beginTransaction();
		
		Book book1=new Book();
		book1.setBookName("Think and Grow rich");
		book1.setBookPages(350);
		book1.setBookPrice(299.50);
		
		Author author=new Author();
		author.setAId(200);
		author.setName("Napolean Hill");
		
		book1.setAuthor(author); //saving author id as foreign key in book table
		
		session.save(book1);
		session.save(author);
		tx.commit();
		
		Book book=session.get(Book.class, 3);
		System.out.println("Book Name:"+book.getBookName());
		System.out.println("Author Name:"+book.getAuthor().getName());
		
		}
		
		catch(HibernateException e)
		{
			System.out.println(e);	
		}
	}
}
