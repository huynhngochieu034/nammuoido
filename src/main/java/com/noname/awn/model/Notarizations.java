package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Notarizations.NotarizationsType;

@Document(collection = "Notarizations")
public class Notarizations extends BaseClass {
	private Logs logs;
	private Documents documents;
	private Abis abis;
	private Operations operations;
	private String name;
	private String description;
	private NotarizationsType type;
	private String key;
	private String hash;
	private StatusType status;

	public Operations getOperations() {
		return operations;
	}
	public void setOperations(Operations operations) {
		this.operations = operations;
	}
	public Documents getDocuments() {
		return documents;
	}
	public void setDocuments(Documents documents) {
		this.documents = documents;
	}
	public Abis getAbis() {
		return abis;
	}
	public void setAbis(Abis abis) {
		this.abis = abis;
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
	public Logs getLogs() {
		return logs;
	}
	public void setLogs(Logs logs) {
		this.logs = logs;
	}
	
}
