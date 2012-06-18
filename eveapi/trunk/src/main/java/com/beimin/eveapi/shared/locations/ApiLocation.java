package com.beimin.eveapi.shared.locations;

public class ApiLocation {
	private long itemID;
	private String itemName;
	private long x;
	private long y;
	private long z;

	public final long getItemID() {
		return itemID;
	}

	public final void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public final String getItemName() {
		return itemName;
	}

	public final void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public final long getX() {
		return x;
	}

	public final void setX(long x) {
		this.x = x;
	}

	public final long getY() {
		return y;
	}

	public final void setY(long y) {
		this.y = y;
	}

	public final long getZ() {
		return z;
	}

	public final void setZ(long z) {
		this.z = z;
	}
}