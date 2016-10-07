package com.beimin.eveapi.model.shared;

import java.util.Date;

public class MarketOrder {
    private long orderID; // ItemID : long
    private long charID; // OwnerID : int
    private long stationID; // LocationID : long
    private int volEntered;
    private int volRemaining;
    private int minVolume;
    private int orderState;
    private int typeID; // TypeID : int
    private int range;
    private int accountKey;
    private int duration;
    private double escrow;
    private double price;
    private int bid;
    private Date issued;

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(final long orderID) {
        this.orderID = orderID;
    }

    public long getCharID() {
        return charID;
    }

    public void setCharID(final long charID) {
        this.charID = charID;
    }

    public long getStationID() {
        return stationID;
    }

    public void setStationID(final long stationID) {
        this.stationID = stationID;
    }

    public int getVolEntered() {
        return volEntered;
    }

    public void setVolEntered(final int volEntered) {
        this.volEntered = volEntered;
    }

    public int getVolRemaining() {
        return volRemaining;
    }

    public void setVolRemaining(final int volRemaining) {
        this.volRemaining = volRemaining;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public void setMinVolume(final int minVolume) {
        this.minVolume = minVolume;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(final int orderState) {
        this.orderState = orderState;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(final int typeID) {
        this.typeID = typeID;
    }

    public int getRange() {
        return range;
    }

    public void setRange(final int range) {
        this.range = range;
    }

    public int getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(final int accountKey) {
        this.accountKey = accountKey;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public double getEscrow() {
        return escrow;
    }

    public void setEscrow(final double escrow) {
        this.escrow = escrow;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(final int bid) {
        this.bid = bid;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(final Date issued) {
        this.issued = issued;
    }
}