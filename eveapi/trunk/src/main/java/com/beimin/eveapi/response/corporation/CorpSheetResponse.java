package com.beimin.eveapi.response.corporation;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.corporation.CorpLogo;
import com.beimin.eveapi.model.corporation.Division;
import com.beimin.eveapi.response.ApiResponse;

public class CorpSheetResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private long corporationID;
	private String corporationName;
	private Long allianceID;
	private String allianceName;
	private Long factionID;
	private String ticker;
	private long ceoID;
	private String ceoName;
	private long stationID;
	private String stationName;
	private String description;
	private String url;
	private double taxRate;
	private int memberCount;
	private int memberLimit;
	private long shares;
	private final Map<Integer, String> divisions = new HashMap<Integer, String>();
	private final Map<Integer, String> walletDivisions = new HashMap<Integer, String>();
	private CorpLogo logo;

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public String getCorporationName() {
		return corporationName;
	}

	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public long getCeoID() {
		return ceoID;
	}

	public void setCeoID(long ceoID) {
		this.ceoID = ceoID;
	}

	public String getCeoName() {
		return ceoName;
	}

	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}

	public long getStationID() {
		return stationID;
	}

	public void setStationID(long stationID) {
		this.stationID = stationID;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getAllianceID() {
		return allianceID;
	}

	public void setAllianceID(Long allianceID) {
		this.allianceID = allianceID;
	}

	public String getAllianceName() {
		return allianceName;
	}

	public void setAllianceName(String allianceName) {
		this.allianceName = allianceName;
	}
	
	public Long getFactionID() {
		return factionID;
	}

	public void setFactionID(Long factionID) {
		this.factionID = factionID;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getMemberLimit() {
		return memberLimit;
	}

	public void setMemberLimit(int memberLimit) {
		this.memberLimit = memberLimit;
	}

	public long getShares() {
		return shares;
	}

	public void setShares(long shares) {
		this.shares = shares;
	}

	public CorpLogo getLogo() {
		return logo;
	}

	public void setLogo(CorpLogo logo) {
		this.logo = logo;
	}

	public void addDivision(Division division) {
		this.divisions.put(division.getAccountKey(), division.getDescription());
	}

	public void addWalletDivision(Division division) {
		this.walletDivisions.put(division.getAccountKey(), division.getDescription());
	}

	public Map<Integer, String> getDivisions() {
		return divisions;
	}

	public Map<Integer, String> getWalletDivisions() {
		return walletDivisions;
	}
}