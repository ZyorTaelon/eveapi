package com.beimin.eveapi.utils.skilllist;

import java.util.Collection;
import java.util.HashSet;

public class ApiSkill {
	private int typeID;
	private int groupID;
	private String typeName;
	private String description;
	private int rank;
	private Collection<ApiRequirement> requiredSkills = new HashSet<ApiRequirement>();
	private final Collection<ApiBonus> boneses = new HashSet<ApiBonus>();

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

	public Collection<ApiRequirement> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(Collection<ApiRequirement> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public void addSkillDetail(Detail skillDetail) {
		if (skillDetail instanceof ApiRequirement) {
			requiredSkills.add((ApiRequirement) skillDetail);
		} else if (skillDetail instanceof ApiBonus) {
			boneses.add((ApiBonus) skillDetail);
		}
	}

	@Override
	public String toString() {
		String result = "\t" + typeName + " (" + rank + ")\n";
		result += "\t\tRequires:\n";
		for (ApiRequirement skillRequirement : requiredSkills) {
			result += "\t\t\t" + skillRequirement + "\n";
		}
		result += "\t\tBonuses:\n";
		for (ApiBonus skillBonus : boneses) {
			result += "\t\t\t" + skillBonus + "\n";
		}

		return result;
	}
}
