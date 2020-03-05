package com.noname.awn.dto;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import com.noname.awn.enums.StatusType;

public class TasksDTO extends BaseClassDTO {
	
	private ObjectId id_user;
	private ObjectId id_sequence;
	private String name;
	private String description;
	private List<String> parameters = new ArrayList<>();
	private List<String> conditions = new ArrayList<>();
	private List<String> actions = new ArrayList<>();
	private StatusType status;
	
	public ObjectId getId_user() {
		return id_user;
	}
	public void setId_user(ObjectId id_user) {
		this.id_user = id_user;
	}
	public ObjectId getId_sequence() {
		return id_sequence;
	}
	public void setId_sequence(ObjectId id_sequence) {
		this.id_sequence = id_sequence;
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
