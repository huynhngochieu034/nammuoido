package com.noname.awn.dto;

import java.util.ArrayList;
import java.util.List;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnumSequence;
import com.noname.awn.enums.TypeEnumSequenceProcedure;

public class SequencesDTO extends BaseClassDTO {
	
	private String name;
	private String description;
	private TypeEnumSequence type;
	private TypeEnumSequenceProcedure procedure;
	private boolean witness;
	private String steps;
	private List<String> parameters = new ArrayList<>();
	private String amount;
	private StatusType status;
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
	public TypeEnumSequence getType() {
		return type;
	}
	public void setType(TypeEnumSequence type) {
		this.type = type;
	}
	public TypeEnumSequenceProcedure getProcedure() {
		return procedure;
	}
	public void setProcedure(TypeEnumSequenceProcedure procedure) {
		this.procedure = procedure;
	}
	public boolean isWitness() {
		return witness;
	}
	public void setWitness(boolean witness) {
		this.witness = witness;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
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
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
}
