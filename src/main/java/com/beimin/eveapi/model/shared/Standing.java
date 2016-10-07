package com.beimin.eveapi.model.shared;

public class Standing {
    private int fromID;
    private String fromName;
    private double standing;

    public void setFromID(final int fromID) {
        this.fromID = fromID;
    }

    public void setFromName(final String fromName) {
        this.fromName = fromName;
    }

    public void setStanding(final double standing) {
        this.standing = standing;
    }

    public int getFromID() {
        return fromID;
    }

    public String getFromName() {
        return fromName;
    }

    public double getStanding() {
        return standing;
    }
}