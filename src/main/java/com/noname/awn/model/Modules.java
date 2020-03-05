package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Modules.ModulesType;

@Document(collection = "Modules")
public class Modules extends BaseClass {

	private Subscriptions subscriptions;
	private String name;
	private String description;
	private ModulesType type;
	private List<String> parameters = new ArrayList<>();
	private StatusType status;
	
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

	public ModulesType getType() {
		return type;
	}
	public void setType(ModulesType type) {
		this.type = type;
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
