package com.noname.awn.dto;

import com.noname.awn.enums.TypeEnum;

public class CertificatorsDTO extends BaseClassDTO {
	
	private String name;
	private String description;
	private TypeEnum type;
	private String url;
	private String call;
	private int port;
	private boolean sandbox;
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
	
	
	
}
