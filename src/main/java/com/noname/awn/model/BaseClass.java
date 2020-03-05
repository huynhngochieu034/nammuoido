package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class BaseClass {
	@Id
	public ObjectId _id;
	
	private boolean hidden;
	private boolean verified;
	private String notes;
	private List<?> timeline = new ArrayList<>();
	
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
	public List<?> getTimeline() {
		return timeline;
	}
	public void setTimeline(List<?> timeline) {
		this.timeline = timeline;
	}
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
}
