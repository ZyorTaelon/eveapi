package com.beimin.eveapi.character.sheet;

public class ApiSkill {
	private int typeID;
	private int level = 0;
	private int skillpoints = 0;
	private boolean unpublished = false;

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSkillpoints() {
		return skillpoints;
	}

	public void setSkillpoints(int skillpoints) {
		this.skillpoints = skillpoints;
	}

	public boolean isUnpublished() {
		return unpublished;
	}

	public void setUnpublished(boolean unpublished) {
		this.unpublished = unpublished;
	}
}