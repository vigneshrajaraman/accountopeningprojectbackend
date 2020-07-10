package com.mits.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Table(name="application_table")
@Entity
@SequenceGenerator(name = "application_seq", initialValue = 100)
public class Application implements Serializable {
	@Id
	private String applicationNo;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private AccountType accountType;
	private CardType cadeType;
	private boolean overeseasAccount;
	private String createUser;
	private Date createDate;
	private String lastModifiedUser;
	private Date lastModifiedDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(String applicationNo, Customer customer, AccountType accountType, CardType cadeType,
			boolean overeseasAccount, String createUser, Date createDate, String lastModifiedUser,
			Date lastModifiedDate, Status status) {
		super();
		this.applicationNo = applicationNo;
		this.customer = customer;
		this.accountType = accountType;
		this.cadeType = cadeType;
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

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public CardType getCadeType() {
		return cadeType;
	}

	public void setCadeType(CardType cadeType) {
		this.cadeType = cadeType;
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
				+ ", cadeType=" + cadeType + ", overeseasAccount=" + overeseasAccount + ", createUser=" + createUser
				+ ", createDate=" + createDate + ", lastModifiedUser=" + lastModifiedUser + ", lastModifiedDate="
				+ lastModifiedDate + ", status=" + status + "]";
	}

}
