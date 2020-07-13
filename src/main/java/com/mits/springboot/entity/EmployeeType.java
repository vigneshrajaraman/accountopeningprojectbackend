package com.mits.springboot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mits.springboot.generator.StringPrefixedSequenceIdGenerator;

@Table(name = "employee_type_table")
@SequenceGenerator(name = "employee_type_seq")
@Entity
public class EmployeeType implements Serializable {
	@Id
	@GenericGenerator(
	        name = "employee_type_seq", 
	        strategy = "com.mits.springboot.generator.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ET_")
	            })
	@GeneratedValue(generator = "employee_type_seq",strategy = GenerationType.SEQUENCE)
	private String employeeTypeId;
	private String employeeTypeName;

	public EmployeeType() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeType(String employeeTypeId, String employeeTypeName) {
		super();
		this.employeeTypeId = employeeTypeId;
		this.employeeTypeName = employeeTypeName;
	}

	public String getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(String employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public String getEmployeeTypeName() {
		return employeeTypeName;
	}

	public void setEmployeeTypeName(String employeeTypeName) {
		this.employeeTypeName = employeeTypeName;
	}

	@Override
	public String toString() {
		return "EmployeeType [employeeTypeId=" + employeeTypeId + ", employeeTypeName=" + employeeTypeName + "]";
	}

}
