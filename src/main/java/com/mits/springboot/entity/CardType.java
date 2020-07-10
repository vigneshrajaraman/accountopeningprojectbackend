package com.mits.springboot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "card_type_table")
@SequenceGenerator(name = "card_type_seq")
@Entity
public class CardType implements Serializable {
	@Id
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
