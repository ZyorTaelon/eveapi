package com.beimin.eveapi.model.shared;

import java.util.ArrayList;
import java.util.List;

public class Asset {
    private final List<Asset> assets = new ArrayList<Asset>();
    private long itemID;
    private Long locationID;
    private int typeID;
    private int quantity;
    private Integer rawQuantity;
    private int flag;
    private boolean singleton;

    public List<Asset> getAssets() {
        return assets;
    }

    public void add(final Asset asset) {
        assets.add(asset);
    }

    public void addAsset(final Asset asset) {
        assets.add(asset);
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(final long itemID) {
        this.itemID = itemID;
    }

    public Long getLocationID() {
        return locationID;
    }

    public void setLocationID(final Long locationID) {
        this.locationID = locationID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(final int typeID) {
        this.typeID = typeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(final int flag) {
        this.flag = flag;
    }

    public Integer getRawQuantity() {
        return rawQuantity;
    }

    public void setRawQuantity(final Integer rawQuantity) {
        this.rawQuantity = rawQuantity;
        if (this.rawQuantity == null) {
            this.rawQuantity = 0;
        }
    }

    public boolean getSingleton() {
        return singleton;
    }

    public void setSingleton(final boolean singleton) {
        this.singleton = singleton;
    }
}