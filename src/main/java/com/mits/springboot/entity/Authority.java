package com.mits.springboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.mits.springboot.generator.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "roles")
@SequenceGenerator(name = "authority_seq", initialValue = 100)
public class Authority implements Serializable {
	@Id
	@GenericGenerator(
	        name = "authority_seq", 
	        strategy = "com.mits.springboot.generator.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUT_")
	            })
	@GeneratedValue(generator = "authority_seq",strategy = GenerationType.SEQUENCE)
	private String id;
	@Column(nullable = false, unique = true)

	private String roleName;

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authority(String id, String name) {
		super();
		this.id = id;
		this.roleName = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", roleName=" + roleName + "]";
	}

}
