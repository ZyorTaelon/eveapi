package com.beimin.eveapi.model.pilot;

import java.util.Date;

public class ContactNotification {
    private long notificationID;
    private long senderID;
    private String senderName;
    private Date sentDate;
    private String messageData;

    public long getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(final long notificationID) {
        this.notificationID = notificationID;
    }

    public long getSenderID() {
        return senderID;
    }

    public void setSenderID(final long senderID) {
        this.senderID = senderID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(final String sentName) {
        senderName = sentName;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(final Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getMessageData() {
        return messageData;
    }

    public void setMessageData(final String messageData) {
        this.messageData = messageData;
    }
}