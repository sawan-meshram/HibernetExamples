package com.example.one_to_one;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeMain {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(EmployeeDetail.class)
				.buildSessionFactory();
		
		Session s = factory.openSession();
		
//	
		
		
//		insert(s);
		read(s);
		
		s.close();
		factory.close();
		
		System.out.println("Transaction Successfully Completed!");
	}
	
	static void insert(Session s) {
		Transaction tx = s.beginTransaction();
		EmployeeDetail ed1 = new EmployeeDetail("Jr. Software Engg", LocalDate.of(2020, 01, 01), 20_00_000);
		Employee e1 = new Employee("Sawan", "Male");
		
		ed1.setEmployee(e1);
		e1.setEmployeeDetail(ed1);
		
		
		s.save(e1);
//		s.save(ed1); // no need, when used, cascade = CascadeType.ALL
		
		tx.commit();
	}
	
	static void read(Session s) {
		Employee e1 = s.get(Employee.class, 1L);
		System.out.println(e1.getName()+" :"+e1.getId());
		
		EmployeeDetail ed = e1.getEmployeeDetail();
		System.out.println(ed.getId()+":"+ed.getPosition()+":"+ed.getSalary());
		
	}
}
