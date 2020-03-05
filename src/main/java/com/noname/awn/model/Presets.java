package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;

@Document(collection = "Presets")
public class Presets extends BaseClass {
	@DBRef
	private Subscriptions subscriptions;
	
	@DBRef
	private List<Devices> devices = new ArrayList<>();
	
	private String name;
	private String description;
	private List<String> parameters = new ArrayList<>();
	private StatusType status;
	
	public List<Devices> getDevices() {
		return devices;
	}
	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}
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

	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
}
