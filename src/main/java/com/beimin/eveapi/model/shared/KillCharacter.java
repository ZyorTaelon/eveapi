package com.beimin.eveapi.model.shared;

public abstract class KillCharacter {
    private long characterID; // ="411109620"
    private String characterName; // ="Pi'rat Tealon"
    private long corporationID; // ="1449814438"
    private String corporationName; // ="The Bastards"
    private Long allianceID; // ="1311549668"
    private String allianceName; // ="The Bastards."
    private int factionID; // ="0"
    private String factionName; // =""

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

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final long corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(final String corporationName) {
        this.corporationName = corporationName;
    }

    public Long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(final Long allianceID) {
        this.allianceID = allianceID;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(final String allianceName) {
        this.allianceName = allianceName;
    }

    public int getFactionID() {
        return factionID;
    }

    public void setFactionID(final int factionID) {
        this.factionID = factionID;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(final String factionName) {
        this.factionName = factionName;
    }
}
