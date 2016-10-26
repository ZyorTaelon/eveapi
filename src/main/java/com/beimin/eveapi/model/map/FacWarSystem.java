package com.beimin.eveapi.model.map;

public class FacWarSystem {
    private int solarSystemID;
    private String solarSystemName;
    private int occupyingFactionID;
    private String occupyingFactionName;
    private boolean contested;
    private int owningFactionID;
    private String owningFactionName;
    private int victoryPoints;
    private int victoryPointThreshold;

    public int getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(final int solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(final String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public int getOccupyingFactionID() {
        return occupyingFactionID;
    }

    public void setOccupyingFactionID(final int occupyingFactionID) {
        this.occupyingFactionID = occupyingFactionID;
    }

    public String getOccupyingFactionName() {
        return occupyingFactionName;
    }

    public void setOccupyingFactionName(final String occupyingFactionName) {
        this.occupyingFactionName = occupyingFactionName;
    }

    public boolean isContested() {
        return contested;
    }

    public void setContested(final boolean contested) {
        this.contested = contested;
    }

    public int getOwningFactionID() {
        return owningFactionID;
    }

    public void setOwningFactionID(int owningFactionID) {
        this.owningFactionID = owningFactionID;
    }

    public String getOwningFactionName() {
        return owningFactionName;
    }

    public void setOwningFactionName(String owningFactionName) {
        this.owningFactionName = owningFactionName;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public int getVictoryPointThreshold() {
        return victoryPointThreshold;
    }

    public void setVictoryPointThreshold(int victoryPointThreshold) {
        this.victoryPointThreshold = victoryPointThreshold;
    }

}
