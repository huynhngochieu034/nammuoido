package com.noname.awn.dto;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnumSequenceProcedure;

public class OperationsDTO extends BaseClassDTO {
	
	private ObjectId id_sequence;
	private String name;
	private String description;
	private TypeEnumSequenceProcedure type;
	private StatusType status;
	public ObjectId getId_sequence() {
		return id_sequence;
	}
	public void setId_sequence(ObjectId id_sequence) {
		this.id_sequence = id_sequence;
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
	public TypeEnumSequenceProcedure getType() {
		return type;
	}
	public void setType(TypeEnumSequenceProcedure type) {
		this.type = type;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	
}
