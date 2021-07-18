package com.hibernate.practiceHibernateOne;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import pojo.BooKDetails;
import pojo.Employee;
import pojo.Laptop;
import pojo.Student;
import pojo.StudentName;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		/*
		 * Create and save table in hibernatedb in mysql
		 * first use old way means with hibernate.cfg.xml(by default name)
		 */     
        
        //Student std1 ;  valid from POJO not Contain Any other class
       // std1.setId(1); //it generate Id automatically
        
		/*
		 * std1.setName("Abhishek Singh"); std1.setAddress("Shivkuti");
		 * std1.setPhoneNo("72710588552");
		 */
        
    	Student std2 = new Student();
    	StudentName sn_std2 = new StudentName();
    	sn_std2.setfName("Raj");
    	sn_std2.setmName("Kumar");
    	sn_std2.setlName("Jha");
    	std2.setAddress("Shivkuti");
    	std2.setPhoneNo("123");
    	std2.setName(sn_std2);
    	
    
		/*
		 * // Configuration con = new
		 * Configuration().configure("My Hibernatecfg xml name").addAnnotatedClass(
		 * Student.class); Configuration con = new
		 * Configuration().configure().addAnnotatedClass(Student.class); //here it is
		 * working because we use default hibernatecfg cml name SessionFactory
		 * sessionFactory = con.buildSessionFactory(); Session session =
		 * sessionFactory.openSession(); Transaction tr = session.beginTransaction();
		 * //session.save(std1); save data in database //Now try to fetch data from db
		 * //std1 = (Student) session.get(Student.class, 3); // session.save(std2); //
		 * tr.commit();
		 * 
		 * 
		 */        
    	
    	
    	//Implement one emp have many laptop onetomany and many to one / manytomany
    	
		  
    	Configuration con = new  Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(BooKDetails.class);
		SessionFactory sessionFactory = con.buildSessionFactory(); 
		Session session =sessionFactory.openSession(); 
		Transaction tr = session.beginTransaction();
		 
        List<Laptop> laptoplist = new ArrayList<Laptop>();
        Laptop l1 = new Laptop();
        l1.setName("MAC -OS");
        
        Laptop l2 = new Laptop();
        l2.setName("HP");
       
        
        List<Employee> emplist = new ArrayList<Employee>();
        Employee emp1 =	new Employee();
        Employee emp2 =	new Employee();
        emp1.setEmpName("Abhishek");
        emp1.setLaptop(laptoplist);
        
        emp2.setEmpName("Ashsih");
        emp2.setLaptop(laptoplist);
        emplist.add(emp1);
        emplist.add(emp2);
        l1.setEmp(emplist);
        l2.setEmp(emplist);
        laptoplist.add(l1);
        laptoplist.add(l2);
       
		
//		  for(Laptop l : laptoplist ) session.save(l);
//		  
//		  for(Employee l : emplist ) session.save(l);
//		  
//		  tr.commit();
		 
        
        
      //Implement one emp have many laptop onetomany and many to one / manytomany
        
		
		/*
		 * Employee empget ; Laptop lp ; empget = (Employee)
		 * session.load(Employee.class,3 ); lp = (Laptop) session.get(Laptop.class, 1);
		 * tr.commit(); System.out.println(empget.getEmpId() +" "+ lp.getName() );
		 * 
		 * Session session1 = sessionFactory.openSession(); Transaction tr1 =
		 * session1.beginTransaction(); empget = (Employee)
		 * session1.get(Employee.class,3 ); tr1.commit(); session1.close();
		 * System.out.println(empget.getEmpName());
		 */

				/*
				 * implement cache and SQL Query and HQL Class BooKlist bookdb
				 */
        //set data in db
		/*
		 * List< BooKDetails> bdlist = new ArrayList<BooKDetails>(); for(int i=0; i< 50
		 * ;i++ ) { BooKDetails temp = new BooKDetails(); temp.setBookName("Book "+
		 * i+1); temp.setBookWriter("Writter "+i+1); Random rand = new Random();
		 * temp.setPrice(rand.nextFloat()*100); bdlist.add(temp); } //bdlist object in
		 * Transient State Session s3 = sessionFactory.openSession();
		 * 
		 * s3.getTransaction().begin(); for( BooKDetails b : bdlist) s3.save(b); //now
		 * object go in Persistent state s3.getTransaction().commit();
		 */
        
        Session s4 = sessionFactory.openSession();
        float price = 2.31f; 			//here we Entity class name
        s4.getTransaction().begin();
        Query<BooKDetails> q = s4.createQuery("from BooKDetails where price > :bookprice ").setParameter("bookprice", price);
        q.setCacheable(true);  ///enable cache for query
        List< BooKDetails> boollist = q.getResultList();
        
        for(BooKDetails bd : boollist)
        	System.out.println(bd);
		s4.getTransaction().commit();
		;
        Session s5 = sessionFactory.openSession();	 
       		//here we Entity class name
        Query<BooKDetails> q1 = s5.createQuery("from BooKDetails where price > :bookprice ").setParameter("bookprice", price);
        List< BooKDetails> boollist2 = q.getResultList();
        
        for(BooKDetails bd : boollist2)
        	System.out.println(bd);
        
        
    }
}
