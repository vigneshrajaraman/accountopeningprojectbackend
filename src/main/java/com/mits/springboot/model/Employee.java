package com.mits.springboot.model;



public class Employee {
	private String employeeId;
	private String firstName;
	private String designation;
	private String employeeType;
	private float salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeId, String firstName, String designation, String employeeType, float salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.designation = designation;
		this.employeeType = employeeType;
		this.salary = salary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
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

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
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
