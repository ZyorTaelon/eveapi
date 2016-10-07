package com.beimin.eveapi.model.shared;

public class KillAttacker {
    private long characterID; // ="1134301496"
    private String characterName; // ="Blackfiredaemon"
    private long corporationID; // ="1885670269"
    private String corporationName; // ="Letiferi Praedones"
    private Long allianceID; // ="1652934118"
    private String allianceName; // ="Wong Thong Crew"
    private int factionID; // ="0"
    private String factionName; // =""
    private double securityStatus; // ="-3.72675620703378"
    private int damageDone; // ="1415"
    private boolean finalBlow; // ="1"
    private int weaponTypeID; // ="2897"
    private int shipTypeID; // ="11999"

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

    public double getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(final double securityStatus) {
        this.securityStatus = securityStatus;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(final int damageDone) {
        this.damageDone = damageDone;
    }

    public boolean isFinalBlow() {
        return finalBlow;
    }

    public void setFinalBlow(final boolean finalBlow) {
        this.finalBlow = finalBlow;
    }

    public int getWeaponTypeID() {
        return weaponTypeID;
    }

    public void setWeaponTypeID(final int weaponTypeID) {
        this.weaponTypeID = weaponTypeID;
    }

    public int getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(final int shipTypeID) {
        this.shipTypeID = shipTypeID;
    }
}