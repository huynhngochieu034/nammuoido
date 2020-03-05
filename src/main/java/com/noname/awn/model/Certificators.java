package com.noname.awn.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnum;

@Document(collection = "Certificators")
public class Certificators extends BaseClass{
	
	private String name;
	private String description;
	private TypeEnum type;
	private String url;
	private String call;
	private int port;
	private boolean sandbox;
	
	@Size(min = 1, max = 100)
	private int data_quality;
	
	private String format;
	private StatusType status;
	private List<String> parameters = new ArrayList<>();

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
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public boolean isSandbox() {
		return sandbox;
	}
	public void setSandbox(boolean sandbox) {
		this.sandbox = sandbox;
	}
	public int getData_quality() {
		return data_quality;
	}
	public void setData_quality(int data_quality) {
		this.data_quality = data_quality;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}
	
	
}
