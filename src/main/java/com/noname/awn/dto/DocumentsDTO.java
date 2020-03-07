package com.noname.awn.dto;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Documents.DocumentFileType;

public class DocumentsDTO extends BaseClassDTO {
	
	private ObjectId id_user;
	private String name;
	private String description;
	private String metadata;
	private DocumentFileType extension;
	private String editor;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	private boolean signed;
	private boolean notarized;
	private boolean encrypted;
	private String host;
	private String path;
	private String hash;
	private String token;
	private StatusType status;
	public ObjectId getId_user() {
		return id_user;
	}
	public void setId_user(ObjectId id_user) {
		this.id_user = id_user;
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
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isSigned() {
		return signed;
	}
	public void setSigned(boolean signed) {
		this.signed = signed;
	}
	public boolean isNotarized() {
		return notarized;
	}
	public void setNotarized(boolean notarized) {
		this.notarized = notarized;
	}
	public boolean isEncrypted() {
		return encrypted;
	}
	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public DocumentFileType getExtension() {
		return extension;
	}
	public void setExtension(DocumentFileType extension) {
		this.extension = extension;
	}
	
	
	
}
