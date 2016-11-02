package com.beimin.eveapi.model.account;

import java.util.Date;

public class Offer {
    private long offerID;
    private Date offeredDate;
    private String from;
    private String to;
    private double ISK;

    public long getOfferID() {
        return offerID;
    }

    public void setOfferID(long offerID) {
        this.offerID = offerID;
    }

    public Date getOfferedDate() {
        return offeredDate;
    }

    public void setOfferedDate(Date offeredDate) {
        this.offeredDate = offeredDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getISK() {
        return ISK;
    }

    public void setISK(double ISK) {
        this.ISK = ISK;
    }
}
