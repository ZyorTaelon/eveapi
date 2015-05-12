package com.beimin.eveapi.model.shared;

import java.util.Date;

public class ContractBid {
	private long bidID;
	private long contractID;
	private long bidderID;
	private Date dateBid;
	private double amount;

	public long getBidID() {
		return bidID;
	}

	public void setBidID(long bidID) {
		this.bidID = bidID;
	}

	public long getContractID() {
		return contractID;
	}

	public void setContractID(long contractID) {
		this.contractID = contractID;
	}

	public long getBidderID() {
		return bidderID;
	}

	public void setBidderID(long bidderID) {
		this.bidderID = bidderID;
	}

	public Date getDateBid() {
		return dateBid;
	}

	public void setDateBid(Date dateBid) {
		this.dateBid = dateBid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}