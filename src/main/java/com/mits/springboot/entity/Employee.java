package com.mits.springboot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "employee_table")
@SequenceGenerator(name = "employee_seq")
@Entity
public class Employee implements Serializable {
	@Id
	private String employeeId;
	private String firstName;
	private String designation;
	private EmployeeType employeeType;
	private float salary;

	public Employee() {
	}

	public Employee(String employeeId, String firstName, String designation, EmployeeType employeeType, float salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.designation = designation;
		this.employeeType = employeeType;
		this.salary = salary;
	}

	public String getEmplyeeId() {
		return employeeId;
	}

	public void setEmplyeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", designation=" + designation
				+ ", employeeType=" + employeeType + ", salary=" + salary + "]";
	}

}
