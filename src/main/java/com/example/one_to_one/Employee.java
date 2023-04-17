package com.example.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee1")
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="employee")
//	@JoinColumn(name="employee_detail_id")
	private EmployeeDetail employeeDetail;
	
	public Employee() {
		super();
	}
	public Employee(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	public Employee(String name, String gender, EmployeeDetail employeeDetail) {
		super();
		this.name = name;
		this.gender = gender;
		this.employeeDetail = employeeDetail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}
	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", employeeDetail=" + employeeDetail
				+ "]";
	}

}
