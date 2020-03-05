package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnumSequenceProcedure;

@Document(collection = "Operations")
public class Operations extends BaseClass {	

	private Sequences sequences;
	private String name;
	private String description;
	private TypeEnumSequenceProcedure type;
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
