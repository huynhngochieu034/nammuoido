package com.noname.awn.dto;

import com.noname.awn.enums.StatusType;

public class CustomersDTO extends BaseClassDTO {
	
	private int id_whmcs;
	private StatusType status;
	public int getId_whmcs() {
		return id_whmcs;
	}
	public void setId_whmcs(int id_whmcs) {
		this.id_whmcs = id_whmcs;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
}
