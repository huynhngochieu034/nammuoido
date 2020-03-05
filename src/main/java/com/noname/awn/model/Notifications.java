package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.noname.awn.enums.StatusType;
import com.noname.awn.enums.Notification.NotificationsPriority;
import com.noname.awn.enums.Notification.NotificationsType;

@Document(collection = "Notifications")
public class Notifications extends BaseClass {
	@DBRef
	private Users user_sender;
	
	@DBRef
	private Users user_receiver;
	
	private String title;
	private String content;
	private String attach;
	private NotificationsType type;
	private NotificationsPriority priority;
	private boolean read;
	private boolean executed;
	private StatusType status;
	
	public Users getUser_sender() {
		return user_sender;
	}
	public void setUser_sender(Users user_sender) {
		this.user_sender = user_sender;
	}
	public Users getUser_receiver() {
		return user_receiver;
	}
	public void setUser_receiver(Users user_receiver) {
		this.user_receiver = user_receiver;
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
