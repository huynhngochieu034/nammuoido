package com.noname.awn.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Logs.LogsType;

@Document(collection = "Logs")
public class Logs {
	@Id
	public ObjectId _id;
	private Users users;
	private Status statuss;
	private Parameters parameters;
	private Sequences sequences;
	private Steps steps;
	private Infos infos;
	private Documents documents;
	
	private Templates templates;
	private Abis abis;
	private Flows flows;
	private Notifications notifications;
	private Tasks tasks;
	private Subscriptions subscriptions;
	private Settings settings;
	
	private Customers customers;
	private Modules modules;
	private Presets presets;
	private Limits limits;
	private Certificators certificators;
	private Seats seats;
	private Devices devices;
	
	private Licences licences;
	private Notarizations notarizations;
	private Wallets wallets;
	private Payments payments;
	
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
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Status getStatuss() {
		return statuss;
	}
	public void setStatuss(Status statuss) {
		this.statuss = statuss;
	}
	public Parameters getParameters() {
		return parameters;
	}
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	public Sequences getSequences() {
		return sequences;
	}
	public void setSequences(Sequences sequences) {
		this.sequences = sequences;
	}
	public Steps getSteps() {
		return steps;
	}
	public void setSteps(Steps steps) {
		this.steps = steps;
	}
	public Infos getInfos() {
		return infos;
	}
	public void setInfos(Infos infos) {
		this.infos = infos;
	}
	public Documents getDocuments() {
		return documents;
	}
	public void setDocuments(Documents documents) {
		this.documents = documents;
	}
	public Templates getTemplates() {
		return templates;
	}
	public void setTemplates(Templates templates) {
		this.templates = templates;
	}
	public Abis getAbis() {
		return abis;
	}
	public void setAbis(Abis abis) {
		this.abis = abis;
	}
	public Flows getFlows() {
		return flows;
	}
	public void setFlows(Flows flows) {
		this.flows = flows;
	}
	public Notifications getNotifications() {
		return notifications;
	}
	public void setNotifications(Notifications notifications) {
		this.notifications = notifications;
	}
	public Tasks getTasks() {
		return tasks;
	}
	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}
	public Subscriptions getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(Subscriptions subscriptions) {
		this.subscriptions = subscriptions;
	}
	public Settings getSettings() {
		return settings;
	}
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public Modules getModules() {
		return modules;
	}
	public void setModules(Modules modules) {
		this.modules = modules;
	}
	public Presets getPresets() {
		return presets;
	}
	public void setPresets(Presets presets) {
		this.presets = presets;
	}
	public Limits getLimits() {
		return limits;
	}
	public void setLimits(Limits limits) {
		this.limits = limits;
	}
	public Certificators getCertificators() {
		return certificators;
	}
	public void setCertificators(Certificators certificators) {
		this.certificators = certificators;
	}
	public Seats getSeats() {
		return seats;
	}
	public void setSeats(Seats seats) {
		this.seats = seats;
	}
	public Devices getDevices() {
		return devices;
	}
	public void setDevices(Devices devices) {
		this.devices = devices;
	}
	public Licences getLicences() {
		return licences;
	}
	public void setLicences(Licences licences) {
		this.licences = licences;
	}
	public Notarizations getNotarizations() {
		return notarizations;
	}
	public void setNotarizations(Notarizations notarizations) {
		this.notarizations = notarizations;
	}
	public Wallets getWallets() {
		return wallets;
	}
	public void setWallets(Wallets wallets) {
		this.wallets = wallets;
	}
	public Payments getPayments() {
		return payments;
	}
	public void setPayments(Payments payments) {
		this.payments = payments;
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
	private boolean verified;
	private String notes;
}
