package com.beimin.eveapi.model.corporation;

import java.util.Date;

public class ContainerLog {
	private Date logTime;
	private long itemID;
	private int itemTypeID;
	private long actorID;
	private String actorName;
	private int flag;
	private int locationID;
	private String action;
	private PasswordType passwordType;
	private Integer typeID;
	private Integer quantity;
	private Integer oldConfiguration;
	private Integer newConfiguration;
//	passwordType="" typeID="" quantity="" oldConfiguration="" newConfiguration=""
			
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

	public int getItemTypeID() {
		return itemTypeID;
	}

	public void setItemTypeID(int itemTypeID) {
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
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

	public PasswordType getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(PasswordType passwordType) {
		this.passwordType = passwordType;
	}

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getOldConfiguration() {
		return oldConfiguration;
	}

	public void setOldConfiguration(Integer oldConfiguration) {
		this.oldConfiguration = oldConfiguration;
	}

	public Integer getNewConfiguration() {
		return newConfiguration;
	}

	public void setNewConfiguration(Integer newConfiguration) {
		this.newConfiguration = newConfiguration;
	}
}