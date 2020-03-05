package com.noname.awn.dto;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Devices.DevicesType;

public class DevicesDTO extends BaseClassDTO {
	
	private ObjectId id_seat;
	private String name;
	private String description;
	private String vendor;
	private int serial;
	private DevicesType type;
	private String certificate;
	private StatusType status;
	public ObjectId getId_seat() {
		return id_seat;
	}
	public void setId_seat(ObjectId id_seat) {
		this.id_seat = id_seat;
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
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public DevicesType getType() {
		return type;
	}
	public void setType(DevicesType type) {
		this.type = type;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	
	
	
}
