package com.noname.awn.dto;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;

public class StatusDTO extends BaseClassDTO {
	
	private ObjectId id_log;
	private String name;
	private String description;
	private String completed;
	private String cache;
	private StatusType status;

	public ObjectId getId_log() {
		return id_log;
	}
	public void setId_log(ObjectId id_log) {
		this.id_log = id_log;
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
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	public String getCache() {
		return cache;
	}
	public void setCache(String cache) {
		this.cache = cache;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	
}
