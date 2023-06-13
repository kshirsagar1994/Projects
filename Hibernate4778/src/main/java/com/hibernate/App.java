package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
    	//1st way
   		//Configuration cfg=new Configuration();
   		//cfg.configure("hibernate.cfg.xml");
   		//SessionFactory factory=cfg.buildSessionFactory();
    	

		//2nd way
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session =factory.openSession();
		
		
		//Transaction tx=session.beginTransaction();
		
		//Book book1=new Book();
			//book1.setBookName("to kill a mocking bird");
			//book1.setBookPages(500);
			//book1.setBookPrice(399.9);
			
			//Book book2=new Book();
			//book2.setBookName("Money Psychology");
			//book2.setBookPages(650);
			//book2.setBookPrice(499);
			
			//session.save(book1); //SAVING the object in database
			//session.save(book2);
			
			//tx.commit(); //Committing the changes
		
			
			//IMP- firstly run ABOVE CODE/ execute then add them to comment
			
			//Retrieve the data from database
			
			//using get() method
			Book book1=session.get(Book.class,1);
			System.out.println(book1);
			
			//using get method if the object is not present it will return null
			Book book3=session.get(Book.class,3);
			System.out.println(book3);
			
			//using load method
			Book book2=session.get(Book.class,2);
			System.out.println(book2);
			
			//using load method and if the object is not present it will throw an exception
			Book book4=session.get(Book.class,4);
			System.out.println(book4);
			
			session.close();
			factory.close();
		
    			
    }
}
