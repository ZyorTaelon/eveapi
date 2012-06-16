package com.beimin.eveapi.transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiWalletTransaction {
	private String transactionDateTime;// ="2007-06-13 20:26:00"
	private long transactionID;// ="619"
	private long quantity;// ="10"
	private String typeName;// ="Strontium Clathrates"
	private long typeID;// ="16275"
	private double price;// ="999.00"
	private long clientID;// ="150208955"
	private String clientName;// ="Mark Roled"
	private long characterID;// ="0"
	private String characterName;// ="Mark Roled"
	private long stationID;// ="60001870"
	private String stationName;// ="Eglennaert I - Moon 11 - Nugoeihuvi
	// Corporation Development Studio"
	private String transactionType;// ="buy"
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Date getTransactionDate() throws ParseException {
		return sdf.parse(transactionDateTime);
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public long getTypeID() {
		return typeID;
	}

	public void setTypeID(long typeID) {
		this.typeID = typeID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getClientID() {
		return clientID;
	}

	public void setClientID(long clientID) {
		this.clientID = clientID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
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

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
