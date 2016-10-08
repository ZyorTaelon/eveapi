package com.beimin.eveapi.model.map;

public class SystemSovereignty {
    private int solarSystemID;
    private int allianceID;
    private Long corporationID;
    private Integer factionID;
    private String solarSystemName;

    public int getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(final int solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public int getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(final int allianceID) {
        this.allianceID = allianceID;
    }

    public Long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final Long corporationID) {
        this.corporationID = corporationID;
    }

    public Integer getFactionID() {
        return factionID;
    }

    public void setFactionID(final Integer factionID) {
        this.factionID = factionID;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(final String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }
}
