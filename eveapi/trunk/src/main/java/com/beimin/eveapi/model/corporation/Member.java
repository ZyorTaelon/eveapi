package com.beimin.eveapi.model.corporation;

import java.util.Date;

public class Member {
	private long characterID;
	private String name;
	private Date startDateTime;
	private int baseID;
	private String base;
	private String title;
	private Date logonDateTime;
	private Date logoffDateTime;
	private int locationID;
	private String location;
	private int shipTypeID;
	private String shipType;
	private long roles;
	private long grantableRoles;

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public int getBaseID() {
		return baseID;
	}

	public void setBaseID(int baseID) {
		this.baseID = baseID;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getLogonDateTime() {
		return logonDateTime;
	}

	public void setLogonDateTime(Date logonDateTime) {
		this.logonDateTime = logonDateTime;
	}

	public Date getLogoffDateTime() {
		return logoffDateTime;
	}

	public void setLogoffDateTime(Date logoffDateTime) {
		this.logoffDateTime = logoffDateTime;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getShipTypeID() {
		return shipTypeID;
	}

	public void setShipTypeID(int shipTypeID) {
		this.shipTypeID = shipTypeID;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public long getRoles() {
		return roles;
	}

	public void setRoles(long roles) {
		this.roles = roles;
	}

	public long getGrantableRoles() {
		return grantableRoles;
	}

	public void setGrantableRoles(long grantableRoles) {
		this.grantableRoles = grantableRoles;
	}
}
