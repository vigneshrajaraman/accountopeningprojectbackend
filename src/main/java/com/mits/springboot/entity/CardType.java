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

@Table(name = "card_type_table")
@SequenceGenerator(name = "card_type_seq")
@Entity
public class CardType implements Serializable {
	@Id
	@GenericGenerator(
	        name = "card_type_seq", 
	        strategy = "com.mits.springboot.generator.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CT_")
	            })
	@GeneratedValue(generator = "card_type_seq",strategy = GenerationType.SEQUENCE)
	private String cardTypeId;
	private String cardTypeName;

	public CardType() {
		// TODO Auto-generated constructor stub
	}

	public CardType(String cardTypeId, String cardTypeName) {
		super();
		this.cardTypeId = cardTypeId;
		this.cardTypeName = cardTypeName;
	}

	public String getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(String cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}
 
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	@Override
	public String toString() {
		return "CardType [cardTypeId=" + cardTypeId + ", cardTypeName=" + cardTypeName + "]";
	}

}
