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
	private int stationID;
	private String stationName;
	private String transactionType;
	private String transactionFor;

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

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
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

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((characterID == null) ? 0 : characterID.hashCode());
	    result = prime * result + ((characterName == null) ? 0 : characterName.hashCode());
	    result = prime * result + (int) (clientID ^ (clientID >>> 32));
	    result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
	    long temp;
	    temp = Double.doubleToLongBits(price);
	    result = prime * result + (int) (temp ^ (temp >>> 32));
	    result = prime * result + quantity;
	    result = prime * result + stationID;
	    result = prime * result + ((stationName == null) ? 0 : stationName.hashCode());
	    result = prime * result + ((transactionDateTime == null) ? 0 : transactionDateTime.hashCode());
	    result = prime * result + ((transactionFor == null) ? 0 : transactionFor.hashCode());
	    result = prime * result + (int) (transactionID ^ (transactionID >>> 32));
	    result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
	    result = prime * result + typeID;
	    result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    WalletTransaction other = (WalletTransaction) obj;
	    if (characterID == null) {
		if (other.characterID != null)
		    return false;
	    } else if (!characterID.equals(other.characterID))
		return false;
	    if (characterName == null) {
		if (other.characterName != null)
		    return false;
	    } else if (!characterName.equals(other.characterName))
		return false;
	    if (clientID != other.clientID)
		return false;
	    if (clientName == null) {
		if (other.clientName != null)
		    return false;
	    } else if (!clientName.equals(other.clientName))
		return false;
	    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	    if (quantity != other.quantity)
		return false;
	    if (stationID != other.stationID)
		return false;
	    if (stationName == null) {
		if (other.stationName != null)
		    return false;
	    } else if (!stationName.equals(other.stationName))
		return false;
	    if (transactionDateTime == null) {
		if (other.transactionDateTime != null)
		    return false;
	    } else if (!transactionDateTime.equals(other.transactionDateTime))
		return false;
	    if (transactionFor == null) {
		if (other.transactionFor != null)
		    return false;
	    } else if (!transactionFor.equals(other.transactionFor))
		return false;
	    if (transactionID != other.transactionID)
		return false;
	    if (transactionType == null) {
		if (other.transactionType != null)
		    return false;
	    } else if (!transactionType.equals(other.transactionType))
		return false;
	    if (typeID != other.typeID)
		return false;
	    if (typeName == null) {
		if (other.typeName != null)
		    return false;
	    } else if (!typeName.equals(other.typeName))
		return false;
	    return true;
	}
}
