package com.beimin.eveapi.response.corporation;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.model.corporation.CorpLogo;
import com.beimin.eveapi.model.corporation.Division;
import com.beimin.eveapi.response.ApiResponse;

public class CorpSheetResponse extends ApiResponse {
    private long corporationID;
    private String corporationName;
    private Long allianceID;
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

    public void setCorporationID(final long corporationID) {
        this.corporationID = corporationID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(final String corporationName) {
        this.corporationName = corporationName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(final String ticker) {
        this.ticker = ticker;
    }

    public long getCeoID() {
        return ceoID;
    }

    public void setCeoID(final long ceoID) {
        this.ceoID = ceoID;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(final String ceoName) {
        this.ceoName = ceoName;
    }

    public long getStationID() {
        return stationID;
    }

    public void setStationID(final long stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(final String stationName) {
        this.stationName = stationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(final Long allianceID) {
        this.allianceID = allianceID;
    }

    public Long getFactionID() {
        return factionID;
    }

    public void setFactionID(final Long factionID) {
        this.factionID = factionID;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(final double taxRate) {
        this.taxRate = taxRate;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(final int memberCount) {
        this.memberCount = memberCount;
    }

    public int getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(final int memberLimit) {
        this.memberLimit = memberLimit;
    }

    public long getShares() {
        return shares;
    }

    public void setShares(final long shares) {
        this.shares = shares;
    }

    public CorpLogo getLogo() {
        return logo;
    }

    public void setLogo(final CorpLogo logo) {
        this.logo = logo;
    }

    public void addDivision(final Division division) {
        divisions.put(division.getAccountKey(), division.getDescription());
    }

    public void addWalletDivision(final Division division) {
        walletDivisions.put(division.getAccountKey(), division.getDescription());
    }

    public Map<Integer, String> getDivisions() {
        return divisions;
    }

    public Map<Integer, String> getWalletDivisions() {
        return walletDivisions;
    }
}
