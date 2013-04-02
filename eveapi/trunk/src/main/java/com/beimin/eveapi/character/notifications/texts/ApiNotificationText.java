package com.beimin.eveapi.character.notifications.texts;


public class ApiNotificationText {
	private long notificationID;
	private String text;

	public long getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(long notificationID) {
		this.notificationID = notificationID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}