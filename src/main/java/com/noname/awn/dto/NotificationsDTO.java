package com.noname.awn.dto;

import org.bson.types.ObjectId;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Notification.NotificationsPriority;
import com.noname.awn.enums.Notification.NotificationsType;

public class NotificationsDTO extends BaseClassDTO {
	
	private ObjectId id_user_sender;
	private ObjectId id_user_receiver;
	
	private String title;
	private String content;
	private String attach;
	private NotificationsType type;
	private NotificationsPriority priority;
	private boolean read;
	private boolean executed;
	private StatusType status;
	
	public ObjectId getId_user_sender() {
		return id_user_sender;
	}
	public void setId_user_sender(ObjectId id_user_sender) {
		this.id_user_sender = id_user_sender;
	}
	public ObjectId getId_user_receiver() {
		return id_user_receiver;
	}
	public void setId_user_receiver(ObjectId id_user_receiver) {
		this.id_user_receiver = id_user_receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public NotificationsType getType() {
		return type;
	}
	public void setType(NotificationsType type) {
		this.type = type;
	}
	public NotificationsPriority getPriority() {
		return priority;
	}
	public void setPriority(NotificationsPriority priority) {
		this.priority = priority;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isExecuted() {
		return executed;
	}
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	
	
}
