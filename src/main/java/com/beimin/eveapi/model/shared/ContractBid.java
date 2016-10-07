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

    public void setBidID(final long bidID) {
        this.bidID = bidID;
    }

    public long getContractID() {
        return contractID;
    }

    public void setContractID(final long contractID) {
        this.contractID = contractID;
    }

    public long getBidderID() {
        return bidderID;
    }

    public void setBidderID(final long bidderID) {
        this.bidderID = bidderID;
    }

    public Date getDateBid() {
        return dateBid;
    }

    public void setDateBid(final Date dateBid) {
        this.dateBid = dateBid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }
}