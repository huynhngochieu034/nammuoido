package com.noname.awn.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;

public class SubscriptionsDTO extends BaseClassDTO {
	
	private ObjectId id_customer;
	private String name;
	private String description;
	private List<String> parameters = new ArrayList<>();
	private StatusType status;
	
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
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
}
