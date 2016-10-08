package com.beimin.eveapi.model.pilot;

public class MailBody {
    private long messageID;
    private String body;

    public long getMessageID() {
        return messageID;
    }

    public void setMessageID(final long messageID) {
        this.messageID = messageID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String title) {
        body = title;
    }
}
