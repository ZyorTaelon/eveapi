package com.beimin.eveapi.shared.wallet.transactions;

import java.text.ParseException;
import java.util.Date;

import com.beimin.eveapi.utils.DateUtils;

public class ApiWalletTransaction implements Comparable<ApiWalletTransaction> {
	private String transactionDateTime;
	private Date transactionDate;
	private long transactionID;
	private long quantity;
	private String typeName;
	private long typeID;
	private double price;
	private long clientID;
	private String clientName;
	private long characterID;
	private String characterName;
	private long stationID;
	private String stationName;
	private String transactionType;
	private String transactionFor;

	public Date getTransactionDate() {
		return transactionDate;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime)
			throws ParseException {
		this.transactionDate = DateUtils.parse(transactionDateTime);
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

	public String getTransactionFor() {
		return transactionFor;
	}

	public void setTransactionFor(String transactionFor) {
		this.transactionFor = transactionFor;
	}

	@Override
	public int compareTo(ApiWalletTransaction o) {
		return Math.round(this.getTransactionID() - o.getTransactionID());
	}
}
