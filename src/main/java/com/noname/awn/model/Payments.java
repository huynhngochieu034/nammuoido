package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnumPaymentCycle;
import com.noname.awn.enums.TypeEnumPaymentGateway;
import com.noname.awn.enums.TypeEnumPaymentResult;
import com.noname.awn.enums.TypeEnumPaymentType;

@Document(collection = "Payments")
public class Payments extends BaseClass {
	@DBRef
	private Wallets wallets;
	
	private String id_transaction;
	private TypeEnumPaymentType type;
	private TypeEnumPaymentCycle cycle;
	private int amount;
	private String currency;
	private String name;
	private String description;
	private TypeEnumPaymentGateway gateway;
	private TypeEnumPaymentResult result;
	private StatusType status;

	public Wallets getWallets() {
		return wallets;
	}
	public void setWallets(Wallets wallets) {
		this.wallets = wallets;
	}
	public String getId_transaction() {
		return id_transaction;
	}
	public void setId_transaction(String id_transaction) {
		this.id_transaction = id_transaction;
	}

	public TypeEnumPaymentType getType() {
		return type;
	}
	public void setType(TypeEnumPaymentType type) {
		this.type = type;
	}
	public TypeEnumPaymentCycle getCycle() {
		return cycle;
	}
	public void setCycle(TypeEnumPaymentCycle cycle) {
		this.cycle = cycle;
	}
	public TypeEnumPaymentGateway getGateway() {
		return gateway;
	}
	public void setGateway(TypeEnumPaymentGateway gateway) {
		this.gateway = gateway;
	}
	public TypeEnumPaymentResult getResult() {
		return result;
	}
	public void setResult(TypeEnumPaymentResult result) {
		this.result = result;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}

}
