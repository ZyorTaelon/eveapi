package com.beimin.eveapi.response.eve;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beimin.eveapi.model.eve.CharacterEmployment;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.response.ApiResponse;

public class CharacterInfoResponse extends ApiResponse {
    private long characterID;
    private String characterName;
    private Race race;
    private Bloodline bloodline;
    private Double accountBalance;
    private Integer skillPoints;
    private String shipName;
    private Integer shipTypeID;
    private String shipTypeName;
    private long corporationID;
    private String corporation;
    private Date corporationDate;
    private Long allianceID;
    private String alliance;
    private Date allianceDate;
    private String lastKnownLocation;
    private double securityStatus;
    private final List<CharacterEmployment> employment = new ArrayList<CharacterEmployment>();

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

    public Race getRace() {
        return race;
    }

    public void setRace(final Race race) {
        this.race = race;
    }

    public Bloodline getBloodline() {
        return bloodline;
    }

    public void setBloodline(final Bloodline bloodline) {
        this.bloodline = bloodline;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(final Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(final Integer skillPoints) {
        this.skillPoints = skillPoints;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(final String shipName) {
        this.shipName = shipName;
    }

    public Integer getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(final Integer shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public String getShipTypeName() {
        return shipTypeName;
    }

    public void setShipTypeName(final String shipTypeName) {
        this.shipTypeName = shipTypeName;
    }

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final long corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(final String corporation) {
        this.corporation = corporation;
    }

    public Date getCorporationDate() {
        return corporationDate;
    }

    public void setCorporationDate(final Date corporationDate) {
        this.corporationDate = corporationDate;
    }

    public Long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(final Long allianceID) {
        this.allianceID = allianceID;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(final String alliance) {
        this.alliance = alliance;
    }

    public Date getAllianceDate() {
        return allianceDate;
    }

    public void setAllianceDate(final Date allianceDate) {
        this.allianceDate = allianceDate;
    }

    public String getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(final String lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

    public double getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(final double securityStatus) {
        this.securityStatus = securityStatus;
    }

    public List<CharacterEmployment> getEmploymentHistory() {
        return employment;
    }

    public void addEmployment(final CharacterEmployment employ) {
        employment.add(employ);
    }
}

