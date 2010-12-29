package com.titan.domain;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CABIN")
public class Cabin implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int deckLevel;
	private int shipId;
	private int bedCount;
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	public int getId(){
		
		return id;
		
	}
	
	public void setId(int i){
		
		id=i;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	
	public void setDeckLevel(int deckLevel) {
		this.deckLevel = deckLevel;
	}
	@Column(name="DECK_LEVEL")
	public int getDeckLevel() {
		return deckLevel;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	@Column(name="SHIP_ID")
	public int getShipId() {
		return shipId;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}
	@Column(name="BED_COUNT")
	public int getBedCount() {
		return bedCount;
	}
	
	
	
	
	
	
}
