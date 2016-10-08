package com.beimin.eveapi.model.shared;

public class Blueprint {
    private long itemID;
    private long locationID;
    private int typeID;
    private String typeName;
    private int flagID;
    private int quantity;
    private int timeEfficiency;
    private int materialEfficiency;
    private int runs;

    public long getItemID() {
        return itemID;
    }

    public void setItemID(final long itemID) {
        this.itemID = itemID;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(final long locationID) {
        this.locationID = locationID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(final int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(final String typeName) {
        this.typeName = typeName;
    }

    public int getFlagID() {
        return flagID;
    }

    public void setFlagID(final int flagID) {
        this.flagID = flagID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public int getTimeEfficiency() {
        return timeEfficiency;
    }

    public void setTimeEfficiency(final int timeEfficiency) {
        this.timeEfficiency = timeEfficiency;
    }

    public int getMaterialEfficiency() {
        return materialEfficiency;
    }

    public void setMaterialEfficiency(final int materialEfficiency) {
        this.materialEfficiency = materialEfficiency;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(final int runs) {
        this.runs = runs;
    }

}
