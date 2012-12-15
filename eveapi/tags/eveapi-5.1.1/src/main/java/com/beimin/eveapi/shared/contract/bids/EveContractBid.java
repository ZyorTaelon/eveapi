package com.beimin.eveapi.shared.contract.bids;

import java.util.Date;

public class EveContractBid {
	private long bidID;
	private long contractID;
	private long bidderID;
	private Date dateBid;
	private double amount;

	public final long getBidID() {
		return bidID;
	}

	public final void setBidID(long bidID) {
		this.bidID = bidID;
	}

	public final long getContractID() {
		return contractID;
	}

	public final void setContractID(long contractID) {
		this.contractID = contractID;
	}

	public final long getBidderID() {
		return bidderID;
	}

	public final void setBidderID(long bidderID) {
		this.bidderID = bidderID;
	}

	public final Date getDateBid() {
		return dateBid;
	}

	public final void setDateBid(Date dateBid) {
		this.dateBid = dateBid;
	}

	public final double getAmount() {
		return amount;
	}

	public final void setAmount(double amount) {
		this.amount = amount;
	}
}