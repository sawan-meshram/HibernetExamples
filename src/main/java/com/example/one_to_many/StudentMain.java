package com.example.one_to_many;

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
				.addAnnotatedClass(Course.class)
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
		
		
		Student s1 = new Student("Sawan Meshram", "Male", LocalDate.of(1990, 9, 9));
		Course c1 = new Course("Java SE");
		Course c2 = new Course("Java J2EE");
		Course c3 = new Course("Hibernet");
		
		s1.addCourse(c1);
		s1.addCourse(c2);
		s1.addCourse(c3);
		
		c1.setStudent(s1);
		c2.setStudent(s1);
		c3.setStudent(s1);
		
		s.save(s1);
		
		s.getTransaction().commit();
	}
	
	static void read(Session s) {
		Student s2 = s.get(Student.class, 1L);
		System.out.println(s2);
		System.out.println(s2.getDob());
		
		Course c1 = s.get(Course.class, 2L);
		System.out.println(c1);
		System.out.println(c1.getStudent().getName());
		
	}
	
	static void update(Session s) {
		s.beginTransaction();
		Student s2 = s.get(Student.class, 1L);
		System.out.println(s2);
//		s2.setName("Sawan Meshram");
//		System.out.println(s2);
		Course c1 = new Course("C#.Net");
		s2.addCourse(c1);
		
		c1.setStudent(s2);
		
		s.update(s2);
		System.out.println(s2);
		s.getTransaction().commit();
		
	}

}
