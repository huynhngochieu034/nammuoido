package com.noname.awn.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.noname.awn.model.Logs;

public class BaseClassDTO {

	public ObjectId _id;
	private boolean hidden;
	private boolean verified;
	private String notes;
	private List<Logs> logs = new ArrayList<>();
	
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
	public List<Logs> getLogs() {
		return logs;
	}
	public void setLogs(List<Logs> logs) {
		this.logs = logs;
	}
}
