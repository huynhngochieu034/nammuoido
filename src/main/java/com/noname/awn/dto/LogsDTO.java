package com.noname.awn.dto;

import java.util.Date;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Logs.LogsType;

public class LogsDTO {
	public ObjectId _id;
	private ObjectId id_user;
	private ObjectId id_operation;
	private ObjectId id_status;
	private ObjectId id_parameter;
	private ObjectId id_sequence;
	private ObjectId id_step;
	private ObjectId id_info;
	private ObjectId id_document;
	private ObjectId id_template;
	private ObjectId id_abis;
	private ObjectId id_flow;
	private ObjectId id_notification;
	private ObjectId id_task;
	private ObjectId id_subscription;
	private ObjectId id_setting;
	private ObjectId id_customer;
	private ObjectId id_module;
	private ObjectId id_preset;
	private ObjectId id_limit;
	private ObjectId id_certificator;
	private ObjectId id_seat;
	private ObjectId id_device;
	private ObjectId id_licence;
	private ObjectId id_notarization;
	private ObjectId id_wallet;
	private ObjectId id_payment;
	
	private String name;
	private String description;
	private LogsType type;
	private int code;
	private String details;
	private boolean vpn;
	private boolean ssl;
	private boolean encrypted;
	private String imei;
	private String ip;
	private String mac;
	private Date time;
	private int sid;
	private String gps;
	private boolean hidden;
	private StatusType status;
	private boolean verified;
	private String notes;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public ObjectId getId_user() {
		return id_user;
	}
	public void setId_user(ObjectId id_user) {
		this.id_user = id_user;
	}
	public ObjectId getId_status() {
		return id_status;
	}
	public void setId_status(ObjectId id_status) {
		this.id_status = id_status;
	}
	public ObjectId getId_parameter() {
		return id_parameter;
	}
	public void setId_parameter(ObjectId id_parameter) {
		this.id_parameter = id_parameter;
	}
	public ObjectId getId_sequence() {
		return id_sequence;
	}
	public void setId_sequence(ObjectId id_sequence) {
		this.id_sequence = id_sequence;
	}
	public ObjectId getId_step() {
		return id_step;
	}
	public void setId_step(ObjectId id_step) {
		this.id_step = id_step;
	}
	public ObjectId getId_info() {
		return id_info;
	}
	public void setId_info(ObjectId id_info) {
		this.id_info = id_info;
	}
	public ObjectId getId_document() {
		return id_document;
	}
	public void setId_document(ObjectId id_document) {
		this.id_document = id_document;
	}
	public ObjectId getId_template() {
		return id_template;
	}
	public void setId_template(ObjectId id_template) {
		this.id_template = id_template;
	}
	public ObjectId getId_abis() {
		return id_abis;
	}
	public void setId_abis(ObjectId id_abis) {
		this.id_abis = id_abis;
	}
	public ObjectId getId_flow() {
		return id_flow;
	}
	public void setId_flow(ObjectId id_flow) {
		this.id_flow = id_flow;
	}
	public ObjectId getId_notification() {
		return id_notification;
	}
	public void setId_notification(ObjectId id_notification) {
		this.id_notification = id_notification;
	}
	public ObjectId getId_task() {
		return id_task;
	}
	public void setId_task(ObjectId id_task) {
		this.id_task = id_task;
	}
	public ObjectId getId_subscription() {
		return id_subscription;
	}
	public void setId_subscription(ObjectId id_subscription) {
		this.id_subscription = id_subscription;
	}
	public ObjectId getId_setting() {
		return id_setting;
	}
	public void setId_setting(ObjectId id_setting) {
		this.id_setting = id_setting;
	}
	public ObjectId getId_customer() {
		return id_customer;
	}
	public void setId_customer(ObjectId id_customer) {
		this.id_customer = id_customer;
	}
	public ObjectId getId_module() {
		return id_module;
	}
	public void setId_module(ObjectId id_module) {
		this.id_module = id_module;
	}
	public ObjectId getId_preset() {
		return id_preset;
	}
	public void setId_preset(ObjectId id_preset) {
		this.id_preset = id_preset;
	}
	public ObjectId getId_limit() {
		return id_limit;
	}
	public void setId_limit(ObjectId id_limit) {
		this.id_limit = id_limit;
	}
	public ObjectId getId_certificator() {
		return id_certificator;
	}
	public void setId_certificator(ObjectId id_certificator) {
		this.id_certificator = id_certificator;
	}
	public ObjectId getId_seat() {
		return id_seat;
	}
	public void setId_seat(ObjectId id_seat) {
		this.id_seat = id_seat;
	}
	public ObjectId getId_device() {
		return id_device;
	}
	public void setId_device(ObjectId id_device) {
		this.id_device = id_device;
	}
	public ObjectId getId_licence() {
		return id_licence;
	}
	public void setId_licence(ObjectId id_licence) {
		this.id_licence = id_licence;
	}
	public ObjectId getId_notarization() {
		return id_notarization;
	}
	public void setId_notarization(ObjectId id_notarization) {
		this.id_notarization = id_notarization;
	}
	public ObjectId getId_wallet() {
		return id_wallet;
	}
	public void setId_wallet(ObjectId id_wallet) {
		this.id_wallet = id_wallet;
	}
	public ObjectId getId_payment() {
		return id_payment;
	}
	public void setId_payment(ObjectId id_payment) {
		this.id_payment = id_payment;
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
	public LogsType getType() {
		return type;
	}
	public void setType(LogsType type) {
		this.type = type;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public boolean isVpn() {
		return vpn;
	}
	public void setVpn(boolean vpn) {
		this.vpn = vpn;
	}
	public boolean isSsl() {
		return ssl;
	}
	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}
	public boolean isEncrypted() {
		return encrypted;
	}
	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
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
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public ObjectId getId_operation() {
		return id_operation;
	}
	public void setId_operation(ObjectId id_operation) {
		this.id_operation = id_operation;
	}
}
