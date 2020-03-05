package com.noname.awn.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Modules.ModulesType;

public class ModulesDTO extends BaseClassDTO {
	
	private ObjectId id_subscription;
	private String name;
	private String description;
	private ModulesType type;
	private List<String> parameters = new ArrayList<>();
	private StatusType status;
	
	public ObjectId getId_subscription() {
		return id_subscription;
	}
	public void setId_subscription(ObjectId id_subscription) {
		this.id_subscription = id_subscription;
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
