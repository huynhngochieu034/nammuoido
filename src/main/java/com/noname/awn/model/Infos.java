package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Infos.InfosAttachType;

@Document(collection = "Infos")
public class Infos extends BaseClass {
	@DBRef
	private Users user;
	
	private String name;
	private String description;
	private String metadata;
	private InfosAttachType attach_type;
	private String attach_name;
	private String attach_host;
	private String attach_path;
	private String attach_hash;
	private String attach_token;
	private StatusType status;

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	public InfosAttachType getAttach_type() {
		return attach_type;
	}
	public void setAttach_type(InfosAttachType attach_type) {
		this.attach_type = attach_type;
	}
	public String getAttach_name() {
		return attach_name;
	}
	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}
	public String getAttach_host() {
		return attach_host;
	}
	public void setAttach_host(String attach_host) {
		this.attach_host = attach_host;
	}
	public String getAttach_path() {
		return attach_path;
	}
	public void setAttach_path(String attach_path) {
		this.attach_path = attach_path;
	}
	public String getAttach_hash() {
		return attach_hash;
	}
	public void setAttach_hash(String attach_hash) {
		this.attach_hash = attach_hash;
	}
	public String getAttach_token() {
		return attach_token;
	}
	public void setAttach_token(String attach_token) {
		this.attach_token = attach_token;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
}
