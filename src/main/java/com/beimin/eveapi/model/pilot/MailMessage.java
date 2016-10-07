package com.beimin.eveapi.model.pilot;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MailMessage {
    private long messageID;
    private long senderID;
    private Date sentDate;
    private String title;
    private Long toCorpOrAllianceID;
    private String toCharacterIDs;
    private String toListIDs;
    private boolean read;

    public long getMessageID() {
        return messageID;
    }

    public void setMessageID(final long messageID) {
        this.messageID = messageID;
    }

    public long getSenderID() {
        return senderID;
    }

    public void setSenderID(final long senderID) {
        this.senderID = senderID;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(final Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Long getToCorpOrAllianceID() {
        return toCorpOrAllianceID;
    }

    public void setToCorpOrAllianceID(final Long toCorpOrAllianceID) {
        if ((toCorpOrAllianceID != null) && (toCorpOrAllianceID > 0L)) {
            this.toCorpOrAllianceID = toCorpOrAllianceID;
        }
    }

    public Set<Long> getCharacterIDs() {
        if ((toCharacterIDs == null) || (toCharacterIDs.length() == 0)) {
            return null;
        }
        final HashSet<Long> characterIDs = new HashSet<Long>();
        for (final String characterID : toCharacterIDs.split(",")) {
            characterIDs.add(Long.parseLong(characterID));
        }
        return characterIDs;
    }

    public String getToCharacterIDs() {
        return toCharacterIDs;
    }

    public void setToCharacterIDs(final String toCharacterIDs) {
        this.toCharacterIDs = toCharacterIDs;
    }

    public Set<Long> getListIDs() {
        if ((toListIDs == null) || (toListIDs.length() == 0)) {
            return null;
        }
        final HashSet<Long> listIDs = new HashSet<Long>();
        for (final String listID : toListIDs.split(",")) {
            listIDs.add(Long.parseLong(listID));
        }
        return listIDs;
    }

    public String getToListIDs() {
        return toListIDs;
    }

    public void setToListIDs(final String toListIDs) {
        this.toListIDs = toListIDs;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(final boolean read) {
        this.read = read;
    }
}
