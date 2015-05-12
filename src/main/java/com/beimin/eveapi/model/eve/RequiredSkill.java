package com.beimin.eveapi.model.eve;

public class RequiredSkill implements CertificateRequirement {
	private int typeID;
	private int level;

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
}