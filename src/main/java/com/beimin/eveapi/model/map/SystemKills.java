package com.beimin.eveapi.model.map;

public class SystemKills {
    private int solarSystemID;
    private int shipKills;
    private int factionKills;
    private int podKills;

    public int getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(final int solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public int getShipKills() {
        return shipKills;
    }

    public void setShipKills(final int shipKills) {
        this.shipKills = shipKills;
    }

    public int getFactionKills() {
        return factionKills;
    }

    public void setFactionKills(final int factionKills) {
        this.factionKills = factionKills;
    }

    public int getPodKills() {
        return podKills;
    }

    public void setPodKills(final int podKills) {
        this.podKills = podKills;
    }
}
