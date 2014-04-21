package com.beimin.eveapi.model.shared;


public class ContractItem {
	private long recordID;
	private int typeID;
	private long quantity;
	private boolean singleton;
	private boolean included;
	private Long rawQuantity;

	public long getRecordID() {
		return recordID;
	}

	public void setRecordID(long recordID) {
		this.recordID = recordID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Long getRawQuantity() {
		return rawQuantity;
	}

	public void setRawQuantity(Long rawQuantity) {
		this.rawQuantity = rawQuantity;
	}

	public boolean isSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	public boolean isIncluded() {
		return included;
	}

	public void setIncluded(boolean included) {
		this.included = included;
	}
}