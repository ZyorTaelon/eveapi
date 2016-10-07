package com.beimin.eveapi.model.pilot;

public class MailingList {
    private long listID;
    private String displayName;

    public long getListID() {
        return listID;
    }

    public void setListID(final long listID) {
        this.listID = listID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }
}