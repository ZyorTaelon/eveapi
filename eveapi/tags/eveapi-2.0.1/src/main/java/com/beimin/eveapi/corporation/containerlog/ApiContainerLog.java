package com.beimin.eveapi.corporation.containerlog;

import java.util.Date;

public class ApiContainerLog {
	private Date logTime; // ="2008-12-21 08:10:00"
	private long itemID; // ="2051471251"
	private long itemTypeID; // ="17366"
	private long actorID; // ="783037732"
	private String actorName; // ="Halo Glory"
	private byte flag; // ="4"
	private int locationID; // ="60011728"
	private String action; // ="Set Name"
	private String passwordType; // =""
	private long typeID; // =""
	private int quantity; // =""
	private int oldConfiguration; // =""
	private int newConfiguration; // =""

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public long getItemTypeID() {
		return itemTypeID;
	}

	public void setItemTypeID(long itemTypeID) {
		this.itemTypeID = itemTypeID;
	}

	public long getActorID() {
		return actorID;
	}

	public void setActorID(long actorID) {
		this.actorID = actorID;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(String passwordType) {
		this.passwordType = passwordType;
	}

	public long getTypeID() {
		return typeID;
	}

	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOldConfiguration() {
		return oldConfiguration;
	}

	public void setOldConfiguration(int oldConfiguration) {
		this.oldConfiguration = oldConfiguration;
	}

	public int getNewConfiguration() {
		return newConfiguration;
	}

	public void setNewConfiguration(int newConfiguration) {
		this.newConfiguration = newConfiguration;
	}
}