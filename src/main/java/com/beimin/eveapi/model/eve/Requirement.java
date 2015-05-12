package com.beimin.eveapi.model.eve;

public class Requirement implements Detail {
	private int typeID;
	private int skillLevel;

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	@Override
	public String toString() {
		return "Type: " + typeID + " at level: " + skillLevel;
	}
}
