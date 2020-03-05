package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;

@Document(collection = "Tasks")
public class Tasks extends BaseClass {	
	
	@DBRef
	private Users user;
	
	@DBRef
	private Sequences sequences;
	
	private String name;
	private String description;
	private List<String> parameters = new ArrayList<>();
	private List<String> conditions = new ArrayList<>();
	private List<String> actions = new ArrayList<>();
	private StatusType status;
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Sequences getSequences() {
		return sequences;
	}
	public void setSequences(Sequences sequences) {
		this.sequences = sequences;
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

	public List<String> getConditions() {
		return conditions;
	}
	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}
	public List<String> getActions() {
		return actions;
	}
	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}

}
