package com.noname.awn.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnumSeat;

public class SeatsDTO extends BaseClassDTO {
	
	private ObjectId id_user;
	private ObjectId id_licence;
	private List<?> devices= new ArrayList<>();
	private String name;
	private String description;
	private TypeEnumSeat type;
	
	private String imei;
	private String ip;
	private String mac;
	private Date time;
	private String gps;
	private StatusType status;
	public ObjectId getId_user() {
		return id_user;
	}
	public void setId_user(ObjectId id_user) {
		this.id_user = id_user;
	}
	public ObjectId getId_licence() {
		return id_licence;
	}
	public void setId_licence(ObjectId id_licence) {
		this.id_licence = id_licence;
	}
	public List<?> getDevices() {
		return devices;
	}
	public void setDevices(List<?> devices) {
		this.devices = devices;
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
	public TypeEnumSeat getType() {
		return type;
	}
	public void setType(TypeEnumSeat type) {
		this.type = type;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
	
	
	
}
