package com.beimin.eveapi.api.calllist;

public class Call {
	private long accessMask;
	private String type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}