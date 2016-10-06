package com.beimin.eveapi.model.shared;

import java.util.Date;

public class WalletTransaction implements Comparable<WalletTransaction> {
	private Date transactionDateTime;
	private long transactionID;
	private int quantity;
	private String typeName;
	private int typeID;
	private double price;
	private long clientID;
	private String clientName;
	private Long characterID;
	private String characterName;
	private long stationID;
	private String stationName;
	private String transactionType;
	private String transactionFor;
	private long journalTransactionID;
	private long clientTypeID;

	public Date getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
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

	public Long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(Long characterID) {
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

	public int compareTo(WalletTransaction o) {
		return Long.compare(this.getTransactionID(), o.getTransactionID());
	}

	public long getJournalTransactionID() {
		return journalTransactionID;
	}

	public void setJournalTransactionID(long journalTransactionID) {
		this.journalTransactionID = journalTransactionID;
	}

	public long getClientTypeID() {
		return clientTypeID;
	}

	public void setClientTypeID(long clientTypeID) {
		this.clientTypeID = clientTypeID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		WalletTransaction that = (WalletTransaction) o;

		if (transactionID != that.transactionID)
			return false;
		if (quantity != that.quantity)
			return false;
		if (typeID != that.typeID)
			return false;
		if (Double.compare(that.price, price) != 0)
			return false;
		if (clientID != that.clientID)
			return false;
		if (stationID != that.stationID)
			return false;
		if (journalTransactionID != that.journalTransactionID)
			return false;
		if (clientTypeID != that.clientTypeID)
			return false;
		if (transactionDateTime != null ? !transactionDateTime.equals(that.transactionDateTime) : that.transactionDateTime != null)
			return false;
		if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null)
			return false;
		if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null)
			return false;
		if (characterID != null ? !characterID.equals(that.characterID) : that.characterID != null)
			return false;
		if (characterName != null ? !characterName.equals(that.characterName) : that.characterName != null)
			return false;
		if (stationName != null ? !stationName.equals(that.stationName) : that.stationName != null)
			return false;
		if (transactionType != null ? !transactionType.equals(that.transactionType) : that.transactionType != null)
			return false;
		return transactionFor != null ? transactionFor.equals(that.transactionFor) : that.transactionFor == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = transactionDateTime != null ? transactionDateTime.hashCode() : 0;
		result = 31 * result + (int) (transactionID ^ (transactionID >>> 32));
		result = 31 * result + quantity;
		result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
		result = 31 * result + typeID;
		temp = Double.doubleToLongBits(price);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (int) (clientID ^ (clientID >>> 32));
		result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
		result = 31 * result + (characterID != null ? characterID.hashCode() : 0);
		result = 31 * result + (characterName != null ? characterName.hashCode() : 0);
		result = 31 * result + (int) (stationID ^ (stationID >>> 32));
		result = 31 * result + (stationName != null ? stationName.hashCode() : 0);
		result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
		result = 31 * result + (transactionFor != null ? transactionFor.hashCode() : 0);
		result = 31 * result + (int) (journalTransactionID ^ (journalTransactionID >>> 32));
		result = 31 * result + (int) (clientTypeID ^ (clientTypeID >>> 32));
		return result;
	}
}
