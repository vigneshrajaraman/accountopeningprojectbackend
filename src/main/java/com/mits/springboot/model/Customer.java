package com.mits.springboot.model;

import com.mits.springboot.entity.Gender;

public class Customer {
	private String customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Employee employee;
	private Gender gender;
	private int age;
	private String correspondenceAddress;
	private String presentAddress;
	private String permanentAddress;
	public Customer(String customerId, String firstName, String middleName, String lastName, Employee employee,
			Gender gender, int age, String correspondenceAddress, String presentAddress, String permanentAddress) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.employee = employee;
		this.gender = gender;
		this.age = age;
		this.correspondenceAddress = correspondenceAddress;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
	}
	public Customer() {
		super();
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCorrespondenceAddress() {
		return correspondenceAddress;
	}
	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", employee=" + employee + ", gender=" + gender + ", age=" + age
				+ ", correspondenceAddress=" + correspondenceAddress + ", presentAddress=" + presentAddress
				+ ", permanentAddress=" + permanentAddress + "]";
	}
	
}
