package com.beimin.eveapi.shared.contract;

import java.util.Date;

public class EveContract {
	private long contractID;
	private long issuerID;
	private long issuerCorpID;
	private long assigneeID;
	private long acceptorID;
	private int startStationID;
	private int endStationID;
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

	public final long getContractID() {
		return contractID;
	}

	public final void setContractID(long contractID) {
		this.contractID = contractID;
	}

	public final long getIssuerID() {
		return issuerID;
	}

	public final void setIssuerID(long issuerID) {
		this.issuerID = issuerID;
	}

	public final long getIssuerCorpID() {
		return issuerCorpID;
	}

	public final void setIssuerCorpID(long issuerCorpID) {
		this.issuerCorpID = issuerCorpID;
	}

	public final long getAssigneeID() {
		return assigneeID;
	}

	public final void setAssigneeID(long assigneeID) {
		this.assigneeID = assigneeID;
	}

	public final long getAcceptorID() {
		return acceptorID;
	}

	public final void setAcceptorID(long acceptorID) {
		this.acceptorID = acceptorID;
	}

	public final int getStartStationID() {
		return startStationID;
	}

	public final void setStartStationID(int startStationID) {
		this.startStationID = startStationID;
	}

	public final int getEndStationID() {
		return endStationID;
	}

	public final void setEndStationID(int endStationID) {
		this.endStationID = endStationID;
	}

	public final ContractType getType() {
		return type;
	}

	public final void setType(ContractType type) {
		this.type = type;
	}

	public final ContractStatus getStatus() {
		return status;
	}

	public final void setStatus(ContractStatus status) {
		this.status = status;
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(String title) {
		this.title = title;
	}

	public final boolean isForCorp() {
		return forCorp;
	}

	public final void setForCorp(boolean forCorp) {
		this.forCorp = forCorp;
	}

	public final ContractAvailability getAvailability() {
		return availability;
	}

	public final void setAvailability(ContractAvailability availability) {
		this.availability = availability;
	}

	public final Date getDateIssued() {
		return dateIssued;
	}

	public final void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public final Date getDateExpired() {
		return dateExpired;
	}

	public final void setDateExpired(Date dateExpired) {
		this.dateExpired = dateExpired;
	}

	public final Date getDateAccepted() {
		return dateAccepted;
	}

	public final void setDateAccepted(Date dateAccepted) {
		this.dateAccepted = dateAccepted;
	}

	public final Date getDateCompleted() {
		return dateCompleted;
	}

	public final void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public final int getNumDays() {
		return numDays;
	}

	public final void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public final double getPrice() {
		return price;
	}

	public final void setPrice(double price) {
		this.price = price;
	}

	public final double getReward() {
		return reward;
	}

	public final void setReward(double reward) {
		this.reward = reward;
	}

	public final double getCollateral() {
		return collateral;
	}

	public final void setCollateral(double collateral) {
		this.collateral = collateral;
	}

	public final double getBuyout() {
		return buyout;
	}

	public final void setBuyout(double buyout) {
		this.buyout = buyout;
	}

	public final double getVolume() {
		return volume;
	}

	public final void setVolume(double volume) {
		this.volume = volume;
	}
}