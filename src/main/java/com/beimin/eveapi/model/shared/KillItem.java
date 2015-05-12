package com.beimin.eveapi.model.shared;

public class KillItem {
	private int typeID; // ="530"
	private int flag; // ="0"
	private int qtyDropped; // ="0"
	private int qtyDestroyed; // ="1"

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getQtyDropped() {
		return qtyDropped;
	}

	public void setQtyDropped(int qtyDropped) {
		this.qtyDropped = qtyDropped;
	}

	public int getQtyDestroyed() {
		return qtyDestroyed;
	}

	public void setQtyDestroyed(int qtyDestroyed) {
		this.qtyDestroyed = qtyDestroyed;
	}
}