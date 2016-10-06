package com.beimin.eveapi.model.shared;

public class KillItem {
	private long typeID; // ="530"
	private int flag; // ="0"
	private int qtyDropped; // ="0"
	private int qtyDestroyed; // ="1"
	private int singleton; // "2" if the item is a blueprint copy, "0" if not.

	public long getTypeID() {
		return typeID;
	}

	public void setTypeID(long typeID) {
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

	public int getSingleton() {
		return singleton;
	}

	public void setSingleton(int singleton) {
		this.singleton = singleton;
	}
}
