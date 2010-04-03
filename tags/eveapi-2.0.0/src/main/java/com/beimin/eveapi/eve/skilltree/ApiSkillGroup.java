package com.beimin.eveapi.eve.skilltree;

import java.util.Collection;
import java.util.HashSet;

public class ApiSkillGroup {
	private String groupName;
	private int groupID;
	private final Collection<ApiSkill> skills = new HashSet<ApiSkill>();

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public void addSkill(ApiSkill skill) {
		skills.add(skill);
	}

	public Collection<ApiSkill> getSkills() {
		return skills;
	}

	@Override
	public String toString() {
		String result = groupName + " (" + skills.size() + " skills)\n";
		for (ApiSkill skill : skills) {
			result += "\t" + skill + "\n";
		}
		return result;
	}
}
