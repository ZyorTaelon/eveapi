package com.beimin.eveapi.model.eve;

import java.util.Collection;
import java.util.HashSet;

public class Skill implements Comparable<Skill> {
	private int typeID;
	private int groupID;
	private String typeName;
	private String description;
	private int rank;
	private boolean published;
	private CharacterAttribute primaryAttribute;
	private CharacterAttribute secondaryAttribute;
	private final Collection<Requirement> requiredSkills = new HashSet<Requirement>();
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

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public CharacterAttribute getPrimaryAttribute() {
		return primaryAttribute;
	}

	public void setPrimaryAttribute(CharacterAttribute primaryAttribute) {
		this.primaryAttribute = primaryAttribute;
	}

	public CharacterAttribute getSecondaryAttribute() {
		return secondaryAttribute;
	}

	public void setSecondaryAttribute(CharacterAttribute secondaryAttribute) {
		this.secondaryAttribute = secondaryAttribute;
	}

	public Collection<Requirement> getRequiredSkills() {
		return requiredSkills;
	}

	public Collection<Bonus> getBoneses() {
		return boneses;
	}

	public void add(Requirement requirement) {
		requiredSkills.add(requirement);
	}

	public void add(Bonus bonus) {
		boneses.add(bonus);
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

	public int compareTo(Skill o) {
		return typeName.compareTo(o.typeName);
	}
}
