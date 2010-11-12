package com.beimin.eveapi.eve.factwar.stats.top;

public abstract class CharacterStat implements FacWarStat {
	private int characterID;
	private String characterName;

	public int getCharacterID() {
		return characterID;
	}

	public void setCharacterID(int characterID) {
		this.characterID = characterID;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

}
