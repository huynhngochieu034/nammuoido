package com.noname.awn.dto;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;

public class WalletsDTO extends BaseClassDTO {
	
	private ObjectId id_customer;
	private String name;
	private String description;
	private String amount;
	
	public ObjectId getId_customer() {
		return id_customer;
	}
	public void setId_customer(ObjectId id_customer) {
		this.id_customer = id_customer;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	private StatusType status;
	
}
