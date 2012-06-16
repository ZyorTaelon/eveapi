package com.beimin.eveapi.api.calllist;

/**
 *
 * @author andrew
 */
public class CallGroup {
	private int groupID;
	private String name;
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
