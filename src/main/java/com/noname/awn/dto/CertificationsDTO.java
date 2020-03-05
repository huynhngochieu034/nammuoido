package com.noname.awn.dto;

import java.util.Date;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusTypeSub;

public class CertificationsDTO extends BaseClassDTO {
	
	private ObjectId id_abis;
	private String name;
	private String description;
	private Date date;
	private int reference;
	private String rate;
	private StatusTypeSub status;
	public ObjectId getId_abis() {
		return id_abis;
	}
	public void setId_abis(ObjectId id_abis) {
		this.id_abis = id_abis;
	}
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
	
}
