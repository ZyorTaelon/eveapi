package com.beimin.eveapi.shared.assetlist;

import java.util.Collection;
import java.util.HashSet;

public class ApiAsset {
	private final Collection<ApiAsset> assets = new HashSet<ApiAsset>();
	private long itemID; // ItemID : long
	private long locationID; // LocationID : long
	private int typeID; // TypeID : int
	private int quantity;
	private int flag;
	private boolean singleton;

	public Collection<ApiAsset> getAssets() {
		return assets;
	}

	public void addAsset(ApiAsset asset) {
		assets.add(asset);
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public long getLocationID() {
		return locationID;
	}

	public void setLocationID(long locationID) {
		this.locationID = locationID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public boolean getSingleton() {
		return singleton;
	}

	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}
}