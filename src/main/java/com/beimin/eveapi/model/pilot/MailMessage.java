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

	public void setMessageID(long messageID) {
		this.messageID = messageID;
	}

	public long getSenderID() {
		return senderID;
	}

	public void setSenderID(long senderID) {
		this.senderID = senderID;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getToCorpOrAllianceID() {
		return toCorpOrAllianceID;
	}

	public void setToCorpOrAllianceID(Long toCorpOrAllianceID) {
		if (toCorpOrAllianceID != null && toCorpOrAllianceID > 0L)
			this.toCorpOrAllianceID = toCorpOrAllianceID;
	}

	public Set<Long> getCharacterIDs() {
		if (toCharacterIDs == null || toCharacterIDs.length() == 0)
			return null;
		HashSet<Long> characterIDs = new HashSet<Long>();
		for (String characterID : toCharacterIDs.split(","))
			characterIDs.add(Long.parseLong(characterID));
		return characterIDs;
	}

	public String getToCharacterIDs() {
		return toCharacterIDs;
	}

	public void setToCharacterIDs(String toCharacterIDs) {
		this.toCharacterIDs = toCharacterIDs;
	}

	public Set<Long> getListIDs() {
		if (toListIDs == null || toListIDs.length() == 0)
			return null;
		HashSet<Long> listIDs = new HashSet<Long>();
		for (String listID : toListIDs.split(","))
			listIDs.add(Long.parseLong(listID));
		return listIDs;
	}

	public String getToListIDs() {
		return toListIDs;
	}

	public void setToListIDs(String toListIDs) {
		this.toListIDs = toListIDs;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
}