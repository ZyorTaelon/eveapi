package com.betterbe.eveapi.skills;

import java.util.Collection;
import java.util.HashSet;

public class Skill {
	private int typeID;
	private int groupID;
	private String typeName;
	private String description;
	private int rank;
	private Collection<Requirement> requiredSkills = new HashSet<Requirement>();
	private final Collection<Bonus> boneses = new HashSet<Bonus>();

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Collection<Requirement> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(Collection<Requirement> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	@SuppressWarnings("unchecked")
	public void addSkillDetail(Detail skillDetail) {
		if (skillDetail instanceof Requirement) {
			requiredSkills.add((Requirement) skillDetail);
		} else if (skillDetail instanceof Bonus) {
			boneses.add((Bonus) skillDetail);
		}
	}

	@Override
	public String toString() {
		String result = "\t" + typeName + " (" + rank + ")\n";
		result += "\t\tRequires:\n";
		for (Requirement skillRequirement : requiredSkills) {
			result += "\t\t\t" + skillRequirement + "\n";
		}
		result += "\t\tBonuses:\n";
		for (Bonus skillBonus : boneses) {
			result += "\t\t\t" + skillBonus + "\n";
		}

		return result;
	}
}
