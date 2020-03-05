package com.noname.awn.dto;

import org.bson.types.ObjectId;
import com.noname.awn.enums.StatusType;

public class AbisDTO extends BaseClassDTO {
	
	private ObjectId id_user;
	public ObjectId getId_user() {
		return id_user;
	}
	public void setId_user(ObjectId id_user) {
		this.id_user = id_user;
	}
	private StatusType status;
		
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
}
