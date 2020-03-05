package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnum;

@Document(collection = "Steps")
public class Steps extends BaseClass {	
	@DBRef
	private Sequences sequences;
	
	private String name;
	private String description;
	private TypeEnum type;
	private List<String> parameters = new ArrayList<>();
	private String amount;
	private String url;
	private String call;
	private String port;
	private boolean sandbox;
	private StatusType status;

	public Sequences getSequences() {
		return sequences;
	}
	public void setSequences(Sequences sequences) {
		this.sequences = sequences;
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

	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCall() {
		return call;
	}
	public void setCall(String call) {
		this.call = call;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public boolean isSandbox() {
		return sandbox;
	}
	public void setSandbox(boolean sandbox) {
		this.sandbox = sandbox;
	}

	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
}
