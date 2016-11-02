package com.beimin.eveapi.model.character;

public class NotificationText {
    private long notificationID;
    private String text;

    public long getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(final long notificationID) {
        this.notificationID = notificationID;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
