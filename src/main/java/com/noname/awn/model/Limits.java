package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusTypeSub;

@Document(collection = "Limits")
public class Limits extends BaseClass {
	@DBRef
	private Subscriptions subscriptions;
	
	private String name;
	private String description;
	private List<String> parameters = new ArrayList<>();
	private StatusTypeSub status;
	
	public Subscriptions getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(Subscriptions subscriptions) {
		this.subscriptions = subscriptions;
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

	public StatusTypeSub getStatus() {
		return status;
	}
	public void setStatus(StatusTypeSub status) {
		this.status = status;
	}

}
