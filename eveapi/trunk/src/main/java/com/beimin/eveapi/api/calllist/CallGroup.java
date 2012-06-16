package com.beimin.eveapi.api.calllist;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrew
 */
public class CallGroup {
	private List<Call> calls = new ArrayList<Call>();
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
	
	public void addCall(Call call) {
		calls.add(call);
	}

	public List<Call> getCalls() {
		return calls;
	}
}