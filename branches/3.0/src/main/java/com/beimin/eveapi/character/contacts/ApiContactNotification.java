package com.beimin.eveapi.character.contacts;

import java.util.Date;

public class ApiContactNotification {
	private long notificationID;
	private long senderID;
	private String senderName;
	private Date sentDate;
	private String messageData;

	public long getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(long notificationID) {
		this.notificationID = notificationID;
	}

	public long getSenderID() {
		return senderID;
	}

	public void setSenderID(long senderID) {
		this.senderID = senderID;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String sentName) {
		this.senderName = sentName;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}
}