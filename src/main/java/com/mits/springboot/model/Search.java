package com.mits.springboot.model;

import java.util.Date;

public class Search {
	private String applicationNo;
	private Date fromCreatedDate;
	private Date toCreatedDate;

	
	public Search(String applicationNo, Date fromCreatedDate, Date toCreatedDate) {
		super();
		this.applicationNo = applicationNo;
		this.fromCreatedDate = fromCreatedDate;
		this.toCreatedDate = toCreatedDate;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setAplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public Date getFromCreatedDate() {
		return fromCreatedDate;
	}

	public void setFromCreatedDate(Date fromCreatedDate) {
		this.fromCreatedDate = fromCreatedDate;
	}

	public Date getToCreatedDate() {
		return toCreatedDate;
	}

	public void setToCreatedDate(Date toCreatedDate) {
		this.toCreatedDate = toCreatedDate;
	}

}
