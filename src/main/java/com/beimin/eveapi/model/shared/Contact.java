package com.beimin.eveapi.model.shared;

public class Contact {
    private int contactID;
    private String contactName;
    private double standing;
    private boolean inWatchlist;
    private int contactTypeID;
    private int labelMask;

    public void setContactID(final int fromID) {
        contactID = fromID;
    }

    public void setContactName(final String fromName) {
        contactName = fromName;
    }

    public void setStanding(final double standing) {
        this.standing = standing;
    }

    public int getContactID() {
        return contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public double getStanding() {
        return standing;
    }

    public boolean isInWatchlist() {
        return inWatchlist;
    }

    public void setInWatchlist(final boolean inWatchlist) {
        this.inWatchlist = inWatchlist;
    }

    public int getContactTypeID() {
        return contactTypeID;
    }

    public void setContactTypeID(final int contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    public int getLabelMask() {
        return labelMask;
    }

    public void setLabelMask(final int labelMask) {
        this.labelMask = labelMask;
    }

}
