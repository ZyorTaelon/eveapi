package com.beimin.eveapi.model.shared;

import java.util.Date;

public class Contract {
    private long contractID;
    private long issuerID;
    private long issuerCorpID;
    private long assigneeID;
    private long acceptorID;
    private long startStationID;
    private long endStationID;
    private ContractType type;
    private ContractStatus status;
    private String title;
    private boolean forCorp;
    private ContractAvailability availability;
    private Date dateIssued;
    private Date dateExpired;
    private Date dateAccepted;
    private Date dateCompleted;
    private int numDays;
    private double price;
    private double reward;
    private double collateral;
    private double buyout;
    private double volume;

    public long getContractID() {
        return contractID;
    }

    public void setContractID(final long contractID) {
        this.contractID = contractID;
    }

    public long getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(final long issuerID) {
        this.issuerID = issuerID;
    }

    public long getIssuerCorpID() {
        return issuerCorpID;
    }

    public void setIssuerCorpID(final long issuerCorpID) {
        this.issuerCorpID = issuerCorpID;
    }

    public long getAssigneeID() {
        return assigneeID;
    }

    public void setAssigneeID(final long assigneeID) {
        this.assigneeID = assigneeID;
    }

    public long getAcceptorID() {
        return acceptorID;
    }

    public void setAcceptorID(final long acceptorID) {
        this.acceptorID = acceptorID;
    }

    public long getStartStationID() {
        return startStationID;
    }

    public void setStartStationID(final long startStationID) {
        this.startStationID = startStationID;
    }

    public long getEndStationID() {
        return endStationID;
    }

    public void setEndStationID(final long endStationID) {
        this.endStationID = endStationID;
    }

    public ContractType getType() {
        return type;
    }

    public void setType(final ContractType type) {
        this.type = type;
    }

    public ContractStatus getStatus() {
        return status;
    }

    public void setStatus(final ContractStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean isForCorp() {
        return forCorp;
    }

    public void setForCorp(final boolean forCorp) {
        this.forCorp = forCorp;
    }

    public ContractAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(final ContractAvailability availability) {
        this.availability = availability;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(final Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(final Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public Date getDateAccepted() {
        return dateAccepted;
    }

    public void setDateAccepted(final Date dateAccepted) {
        this.dateAccepted = dateAccepted;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(final Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public int getNumDays() {
        return numDays;
    }

    public void setNumDays(final int numDays) {
        this.numDays = numDays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(final double reward) {
        this.reward = reward;
    }

    public double getCollateral() {
        return collateral;
    }

    public void setCollateral(final double collateral) {
        this.collateral = collateral;
    }

    public double getBuyout() {
        return buyout;
    }

    public void setBuyout(final double buyout) {
        this.buyout = buyout;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(final double volume) {
        this.volume = volume;
    }
}
