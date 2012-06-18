package com.beimin.eveapi.api.calllist;

import com.beimin.eveapi.shared.KeyType;

public class Call {
	private long accessMask;
	private KeyType type;
	private String name;
	private int groupID;
	private String description;

	public long getAccessMask() {
		return accessMask;
	}

	public void setAccessMask(long accessMask) {
		this.accessMask = accessMask;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public KeyType getType() {
		return type;
	}

	public void setType(KeyType type) {
		this.type = type;
	}
}