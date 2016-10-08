package com.beimin.eveapi.model.eve;

public class CharacterAffiliation {
    private String characterName;
    private long characterID;
    private String corporationName;
    private long corporationID;
    private String allianceName;
    private Long allianceID;
    private String factionName;
    private Long factionID;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(final String corporationName) {
        this.corporationName = corporationName;
    }

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final long corporationID) {
        this.corporationID = corporationID;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(final String allianceName) {
        this.allianceName = allianceName;
    }

    public Long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(final Long allianceID) {
        this.allianceID = allianceID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(final String factionName) {
        this.factionName = factionName;
    }

    public Long getFactionID() {
        return factionID;
    }

    public void setFactionID(final Long factionID) {
        this.factionID = factionID;
    }
}
