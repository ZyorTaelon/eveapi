package com.beimin.eveapi.eve.character;

import java.util.Date;

import com.beimin.eveapi.core.ApiResponse;
import com.beimin.eveapi.shared.character.EveBloodline;
import com.beimin.eveapi.shared.character.EveRace;

public class CharacterInfoResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private long characterID;
	private String characterName;
	private EveRace race;
	private EveBloodline bloodline;
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

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public EveRace getRace() {
		return race;
	}

	public void setRace(EveRace race) {
		this.race = race;
	}

	public EveBloodline getBloodline() {
		return bloodline;
	}

	public void setBloodline(EveBloodline bloodline) {
		this.bloodline = bloodline;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Integer getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Integer getShipTypeID() {
		return shipTypeID;
	}

	public void setShipTypeID(Integer shipTypeID) {
		this.shipTypeID = shipTypeID;
	}

	public String getShipTypeName() {
		return shipTypeName;
	}

	public void setShipTypeName(String shipTypeName) {
		this.shipTypeName = shipTypeName;
	}

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public Date getCorporationDate() {
		return corporationDate;
	}

	public void setCorporationDate(Date corporationDate) {
		this.corporationDate = corporationDate;
	}

	public Long getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(Long allianceID) {
		this.allianceID = allianceID;
	}

	public String getAlliance() {
		return alliance;
	}

	public void setAlliance(String alliance) {
		this.alliance = alliance;
	}

	public Date getAllianceDate() {
		return allianceDate;
	}

	public void setAllianceDate(Date allianceDate) {
		this.allianceDate = allianceDate;
	}

	public String getLastKnownLocation() {
		return lastKnownLocation;
	}

	public void setLastKnownLocation(String lastKnownLocation) {
		this.lastKnownLocation = lastKnownLocation;
	}

	public double getSecurityStatus() {
		return securityStatus;
	}

	public void setSecurityStatus(double securityStatus) {
		this.securityStatus = securityStatus;
	}
}