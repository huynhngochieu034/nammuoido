package com.noname.awn.dto;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Notarizations.NotarizationsType;

public class NotarizationsDTO extends BaseClassDTO {
	
	private ObjectId id_log;
	private ObjectId id_document;
	private ObjectId id_abis;
	private ObjectId id_operation;
	
	private String name;
	private String description;
	private NotarizationsType type;
	private String key;
	private String hash;
	private StatusType status;
	
	public ObjectId getId_log() {
		return id_log;
	}
	public void setId_log(ObjectId id_log) {
		this.id_log = id_log;
	}
	public ObjectId getId_document() {
		return id_document;
	}
	public void setId_document(ObjectId id_document) {
		this.id_document = id_document;
	}
	public ObjectId getId_abis() {
		return id_abis;
	}
	public void setId_abis(ObjectId id_abis) {
		this.id_abis = id_abis;
	}
	public ObjectId getId_operation() {
		return id_operation;
	}
	public void setId_operation(ObjectId id_operation) {
		this.id_operation = id_operation;
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
	public NotarizationsType getType() {
		return type;
	}
	public void setType(NotarizationsType type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	
	
}
