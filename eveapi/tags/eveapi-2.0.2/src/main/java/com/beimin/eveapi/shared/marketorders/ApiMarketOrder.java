package com.beimin.eveapi.shared.marketorders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiMarketOrder {
	private long orderID; //ItemID : long
	private long charID; //OwnerID : int
	private long stationID; //LocationID : long
	private int volEntered;
	private int volRemaining;
	private int minVolume;
	private int orderState;
	private int typeID;  //TypeID : int
	private int range;
	private int accountKey;
	private int duration;
	private double escrow;
	private double price;
	private int bid;
	private String issued;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getCharID() {
		return charID;
	}

	public void setCharID(long charID) {
		this.charID = charID;
	}

	public long getStationID() {
		return stationID;
	}

	public void setStationID(long stationID) {
		this.stationID = stationID;
	}

	public int getVolEntered() {
		return volEntered;
	}

	public void setVolEntered(int volEntered) {
		this.volEntered = volEntered;
	}

	public int getVolRemaining() {
		return volRemaining;
	}

	public void setVolRemaining(int volRemaining) {
		this.volRemaining = volRemaining;
	}

	public int getMinVolume() {
		return minVolume;
	}

	public void setMinVolume(int minVolume) {
		this.minVolume = minVolume;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(int accountKey) {
		this.accountKey = accountKey;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getEscrow() {
		return escrow;
	}

	public void setEscrow(double escrow) {
		this.escrow = escrow;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public Date getIssuedDate() throws ParseException {
		return sdf.parse(issued);
	}

	public String getIssued() {
		return issued;
	}

	public void setIssued(String issued) {
		this.issued = issued;
	}
}