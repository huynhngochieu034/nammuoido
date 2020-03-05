package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;

@Document(collection = "Abis")
public class Abis extends BaseClass {
	@DBRef
	private Users user;
	
	private StatusType status;
		
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
