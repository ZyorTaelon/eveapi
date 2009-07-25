package com.beimin.eveapi.asset;

import java.util.Collection;
import java.util.HashSet;

public class ApiAsset {
	private final Collection<ApiAsset> assets = new HashSet<ApiAsset>();
	private int itemID;
	private int locationID;
	private int typeID;
	private int quantity;
	private int flag;
	private int singleton;

	public Collection<ApiAsset> getAssets() {
		return assets;
	}

	public void addAsset(ApiAsset asset) {
		assets.add(asset);
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
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

	public int getSingleton() {
		return singleton;
	}

	public void setSingleton(int singleton) {
		this.singleton = singleton;
	}
}
