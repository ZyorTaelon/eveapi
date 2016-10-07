package com.beimin.eveapi.model.eve;

public class FactionWar {
    private int factionID;
    private String factionName;
    private int againstID;
    private String againstName;

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

    public int getAgainstID() {
        return againstID;
    }

    public void setAgainstID(final int againstID) {
        this.againstID = againstID;
    }

    public String getAgainstName() {
        return againstName;
    }

    public void setAgainstName(final String againstName) {
        this.againstName = againstName;
    }
}