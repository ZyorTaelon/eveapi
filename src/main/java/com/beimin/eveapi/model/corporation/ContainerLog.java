package com.beimin.eveapi.model.corporation;

import java.util.Date;

public class ContainerLog {
    private Date logTime;
    private long itemID;
    private int itemTypeID;
    private long actorID;
    private String actorName;
    private int flag;
    private int locationID;
    private String action;
    private PasswordType passwordType;
    private Integer typeID;
    private Integer quantity;
    private Integer oldConfiguration;
    private Integer newConfiguration;

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(final Date logTime) {
        this.logTime = logTime;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(final long itemID) {
        this.itemID = itemID;
    }

    public int getItemTypeID() {
        return itemTypeID;
    }

    public void setItemTypeID(final int itemTypeID) {
        this.itemTypeID = itemTypeID;
    }

    public long getActorID() {
        return actorID;
    }

    public void setActorID(final long actorID) {
        this.actorID = actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(final String actorName) {
        this.actorName = actorName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(final int flag) {
        this.flag = flag;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(final int locationID) {
        this.locationID = locationID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public PasswordType getPasswordType() {
        return passwordType;
    }

    public void setPasswordType(final PasswordType passwordType) {
        this.passwordType = passwordType;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(final Integer typeID) {
        this.typeID = typeID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOldConfiguration() {
        return oldConfiguration;
    }

    public void setOldConfiguration(final Integer oldConfiguration) {
        this.oldConfiguration = oldConfiguration;
    }

    public Integer getNewConfiguration() {
        return newConfiguration;
    }

    public void setNewConfiguration(final Integer newConfiguration) {
        this.newConfiguration = newConfiguration;
    }
}