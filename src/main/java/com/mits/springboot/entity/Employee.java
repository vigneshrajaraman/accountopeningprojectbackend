package com.mits.springboot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mits.springboot.generator.StringPrefixedSequenceIdGenerator;

@Table(name = "employee_table")
@SequenceGenerator(name = "employee_seq")
@Entity
public class Employee implements Serializable {
	@Id
	@GenericGenerator(
	        name = "employee_seq", 
	        strategy = "com.mits.springboot.generator.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EMP_")
	            })
	@GeneratedValue(generator = "employee_seq",strategy = GenerationType.SEQUENCE)
	private String employeeId;
	private String firstName;
	private String designation;
	@ManyToOne
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
