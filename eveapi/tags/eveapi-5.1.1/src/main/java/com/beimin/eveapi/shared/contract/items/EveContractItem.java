package com.beimin.eveapi.shared.contract.items;


public class EveContractItem {
	private long recordID;
	private int typeID;
	private long quantity;
	private boolean singleton;
	private boolean included;

	public final long getRecordID() {
		return recordID;
	}

	public final void setRecordID(long recordID) {
		this.recordID = recordID;
	}

	public final int getTypeID() {
		return typeID;
	}

	public final void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public final long getQuantity() {
		return quantity;
	}

	public final void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public final boolean isSingleton() {
		return singleton;
	}

	public final void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	public final boolean isIncluded() {
		return included;
	}

	public final void setIncluded(boolean included) {
		this.included = included;
	}
}