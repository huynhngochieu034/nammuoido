package com.noname.awn.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.TypeEnumSeat;

@Document(collection = "Seats")
public class Seats extends BaseClass {
	@DBRef
	private Users users;
	
	@DBRef
	private Licences licences;
	
	@DBRef
	private List<Devices> devices= new ArrayList<>();
	
	private String name;
	private String description;
	private TypeEnumSeat type;
	
	private String imei;
	private String ip;
	private String mac;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date time;
	
	private String gps;
	private StatusType status;

	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Licences getLicences() {
		return licences;
	}
	public void setLicences(Licences licences) {
		this.licences = licences;
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
	public List<Devices> getDevices() {
		return devices;
	}
	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}	
	
}
