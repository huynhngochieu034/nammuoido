package com.noname.awn.dto;

import com.noname.awn.enums.StatusType;

public class LicencesDTO extends BaseClassDTO {
	
	private String name;
	private String description;
	private String key;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
}
