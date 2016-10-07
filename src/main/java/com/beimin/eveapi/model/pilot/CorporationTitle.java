package com.beimin.eveapi.model.pilot;

public class CorporationTitle {
    private long titleID;
    private String titleName;

    public long getTitleID() {
        return titleID;
    }

    public void setTitleID(final long titleID) {
        this.titleID = titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(final String titleName) {
        this.titleName = titleName;
    }
}