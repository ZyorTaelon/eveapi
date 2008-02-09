package com.betterbe.eveapi.skills;

import java.util.Collection;
import java.util.HashSet;

public class SkillGroup {
	private String groupName;
	private int groupID;
	private final Collection<Skill> skills = new HashSet<Skill>();

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

	public void addSkill(Skill skill) {
		skills.add(skill);
	}

	public Collection<Skill> getSkills() {
		return skills;
	}

	@Override
	public String toString() {
		String result = groupName + " (" + skills.size() + " skills)\n";
		for (Skill skill : skills) {
			result += "\t" + skill + "\n";
		}
		return result;
	}
}
