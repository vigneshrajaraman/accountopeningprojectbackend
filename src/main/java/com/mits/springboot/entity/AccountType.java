package com.mits.springboot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "account_type_table")
@Entity
@SequenceGenerator(name = "account_type_seq", initialValue = 100)
public class AccountType implements Serializable {
	@Id
	private String accountTypeId;
	private String accountTypeName;

	public AccountType() {
		// TODO Auto-generated constructor stub
	}

	public AccountType(String accountTypeId, String accountTypeName) {
		super();
		this.accountTypeId = accountTypeId;
		this.accountTypeName = accountTypeName;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}

	@Override
	public String toString() {
		return "AccountType [accountTypeId=" + accountTypeId + ", accountTypeName=" + accountTypeName + "]";
	}

}
