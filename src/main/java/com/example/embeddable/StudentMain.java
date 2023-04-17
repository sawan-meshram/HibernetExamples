package com.example.embeddable;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();
		
//		
		
		Session s = factory.openSession();
		
//		insert(s);
		read(s);
//		update(s);
		
		s.close();
		factory.close();
		System.out.println("Transaction Successfully Completed!");
	}

	static void insert(Session s) {
		s.beginTransaction();
		
		Address a1 = new Address("Khamla road", "Nagpur", "MH", "440025");
		Student s1 = new Student("Sawan Meshram", "Male", LocalDate.of(1990, 9, 9), a1);
		
		s.save(s1);
		
		s.getTransaction().commit();
	}
	
	static void read(Session s) {
		Student s2 = s.get(Student.class, 1L);
		System.out.println(s2);
		System.out.println(s2.getDob());
		
	}
	
	static void update(Session s) {
		s.beginTransaction();
		Student s2 = s.get(Student.class, 1L);
		System.out.println(s2);
		s2.setName("Sawan Meshram");

		System.out.println(s2);
		s.update(s2);
		
		s.getTransaction().commit();
		
	}
	
}
