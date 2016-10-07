package com.beimin.eveapi.model.corporation;

public class Shareholder {
    private long shareholderID;
    private String shareholderName;
    private Long shareholderCorporationID;
    private String shareholderCorporationName;
    private int shares;

    public long getShareholderID() {
        return shareholderID;
    }

    public void setShareholderID(final long shareholderID) {
        this.shareholderID = shareholderID;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(final String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public Long getShareholderCorporationID() {
        return shareholderCorporationID;
    }

    public void setShareholderCorporationID(final Long shareholderCorporationID) {
        this.shareholderCorporationID = shareholderCorporationID;
    }

    public String getShareholderCorporationName() {
        return shareholderCorporationName;
    }

    public void setShareholderCorporationName(final String shareholderCorporationName) {
        this.shareholderCorporationName = shareholderCorporationName;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(final int shares) {
        this.shares = shares;
    }
}