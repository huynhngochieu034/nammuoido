package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;

@Document(collection = "Status")
public class Status extends BaseClass {
	@DBRef
	private Logs logss;
	
	private String name;
	private String description;
	private String completed;
	private String cache;
	private StatusType status;
	
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
	public Logs getLogss() {
		return logss;
	}
	public void setLogss(Logs logss) {
		this.logss = logss;
	}
	
	
}
