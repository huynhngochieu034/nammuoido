package com.noname.awn.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusTypeSub;

@Document(collection = "Certifications")
public class Certifications extends BaseClass {

	private Abis abis;
	private String name;
	private String description;
	private Date date;
	private int reference;
	private String rate;
	
	private StatusTypeSub status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}

	public StatusTypeSub getStatus() {
		return status;
	}
	public void setStatus(StatusTypeSub status) {
		this.status = status;
	}
	public Abis getAbis() {
		return abis;
	}
	public void setAbis(Abis abis) {
		this.abis = abis;
	}
	
	
}
