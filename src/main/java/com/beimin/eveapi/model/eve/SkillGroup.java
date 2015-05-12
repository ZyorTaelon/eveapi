package com.beimin.eveapi.model.eve;

import java.util.ArrayList;
import java.util.Collection;

public class SkillGroup implements Comparable<SkillGroup> {
	private String groupName;
	private int groupID;
	private final Collection<Skill> skills = new ArrayList<Skill>();

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

	public void add(Skill skill) {
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

	public int compareTo(SkillGroup o) {
		return groupName.compareTo(o.groupName);
	}
}
