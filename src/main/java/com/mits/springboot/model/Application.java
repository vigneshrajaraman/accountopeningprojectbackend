package com.mits.springboot.model;

import java.util.Date;

import com.mits.springboot.entity.Status;

public class Application {
	private String applicationNo;
	private Customer customer;
	private String accountType;
	private String cardType;
	private boolean overeseasAccount;
	private String createUser;
	private Date createDate;
	private String lastModifiedUser;
	private Date lastModifiedDate;
	private Status status;

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(String applicationNo, Customer customer, String accountType, String cardType,
			boolean overeseasAccount, String createUser, Date createDate, String lastModifiedUser,
			Date lastModifiedDate, Status status) {
		super();
		this.applicationNo = applicationNo;
		this.customer = customer;
		this.accountType = accountType;
		this.cardType = cardType;
		this.overeseasAccount = overeseasAccount;
		this.createUser = createUser;
		this.createDate = createDate;
		this.lastModifiedUser = lastModifiedUser;
		this.lastModifiedDate = lastModifiedDate;
		this.status = status;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public boolean isOvereseasAccount() {
		return overeseasAccount;
	}

	public void setOvereseasAccount(boolean overeseasAccount) {
		this.overeseasAccount = overeseasAccount;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Application [applicationNo=" + applicationNo + ", customer=" + customer + ", accountType=" + accountType
				+ ", cardType=" + cardType + ", overeseasAccount=" + overeseasAccount + ", createUser=" + createUser
				+ ", createDate=" + createDate + ", lastModifiedUser=" + lastModifiedUser + ", lastModifiedDate="
				+ lastModifiedDate + ", status=" + status + "]";
	}

}
