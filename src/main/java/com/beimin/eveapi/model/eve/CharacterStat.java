package com.beimin.eveapi.model.eve;

public abstract class CharacterStat implements FacWarStat {
    private long characterID;
    private String characterName;

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

}
