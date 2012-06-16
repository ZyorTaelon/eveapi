package com.beimin.eveapi.character.mailmessages;

import java.util.Date;

public class ApiEveMai {
	private long messageID;
	private long senderID;
	private Date sentDate;
	private String title;
	private Long toCorpOrAllianceID;
	private Long toCharacterIDs;
	private Long toListIDs;
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
		if(toCorpOrAllianceID>0L)
			this.toCorpOrAllianceID = toCorpOrAllianceID;
	}
	public Long getToCharacterIDs() {
		return toCharacterIDs;
	}
	public void setToCharacterIDs(Long toCharacterIDs) {
		if(toCharacterIDs>0L)
		this.toCharacterIDs = toCharacterIDs;
	}
	public Long getToListIDs() {
		return toListIDs;
	}
	public void setToListIDs(Long toListIDs) {
		if(toListIDs>0L)
		this.toListIDs = toListIDs;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
}