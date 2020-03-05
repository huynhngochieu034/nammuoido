package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class BaseClass {
	@Id
	public ObjectId _id;
	
	private boolean hidden;
	private boolean verified;
	private String notes;
	
	@DBRef
	private List<Logs> logs = new ArrayList<>();
	
	public List<Logs> getLogs() {
		return logs;
	}
	public void setLogs(List<Logs> logs) {
		this.logs = logs;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
}
