package com.beimin.eveapi.model.pilot;

import java.util.Date;

import com.beimin.eveapi.model.shared.AbstractMedal;

public class Medal extends AbstractMedal {
    private String reason;
    private String status;
    private long issuerID;
    private Date issued;
    private Long corporationID;

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public boolean isPublic() {
        return status.equals("public");
    }

    public long getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(final long issuerID) {
        this.issuerID = issuerID;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(final Date issued) {
        this.issued = issued;
    }

    public Long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final Long corporationID) {
        this.corporationID = corporationID;
    }
}