package com.beimin.eveapi.model.eve;

public class CharacterLookup {
    private String name;
    private long characterID;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }
}
