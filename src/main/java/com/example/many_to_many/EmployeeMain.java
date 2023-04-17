package com.example.many_to_many;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Project.class)
				.buildSessionFactory();
		
		Session s = factory.openSession();
		
		
		insert(s);
		
		s.close();
		factory.close();
		System.out.println("Transaction Successfully Completed!");
	}
	static void insert(Session s) {
		Transaction tx = s.beginTransaction();
		
//		List<Employee> employees = new ArrayList<>();
//		List<Project> project = new ArrayList<>();
		
		Employee e1 = new Employee("Sawan Meshram", new ArrayList<>());
		Employee e2 = new Employee("Swapnil Meshram", new ArrayList<>());
		Employee e3 = new Employee("Jigvesh Meshram", new ArrayList<>());
		Employee e4 = new Employee("Aradhana Meshram", new ArrayList<>());
		
		Project p1 = new Project("Builder Project", new ArrayList<>());
		Project p2 = new Project("MBD", new ArrayList<>());
		Project p3 = new Project("CBD", new ArrayList<>());
//		Project p4 = new Project("SAC", new ArrayList<>());
//		Project p5 = new Project("CRE", new ArrayList<>());
		

		e1.addProject(p1);
		e1.addProject(p2);
		e1.addProject(p3);

		
		e2.addProject(p2);
		e2.addProject(p3);

		e3.addProject(p1);
		
		p1.addEmployee(e1);
		p1.addEmployee(e3);
		
		p2.addEmployee(e1);
		p2.addEmployee(e2);
		
		p3.addEmployee(e1);
		p3.addEmployee(e2);
		
		s.save(e1);
		s.save(e2);
		s.save(e3);
		s.save(e4);
//		s.save(ed1); // no need, when used, cascade = CascadeType.ALL
		
		tx.commit();
	}
	
	static void read(Session s) {
//		Employee e1 = s.get(Employee.class, 1L);
//		System.out.println(e1.getName()+" :"+e1.getId());
//		
//		EmployeeDetail ed = e1.getEmployeeDetail();
//		System.out.println(ed.getId()+":"+ed.getPosition()+":"+ed.getSalary());
//		
	}
	
}
