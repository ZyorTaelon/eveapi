package com.beimin.eveapi.model.eve;

import java.util.Date;

public class CharacterEmployment {
    private long recordID;
    private Long corporationID;
    private String corporationName;
    private Date startDate;

    public Long getCorporationID() {
        return corporationID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setCorporationID(final Long id) {
        corporationID = id;
    }

    public void setStartDate(final Date date) {
        startDate = date;
    }

    public long getRecordID() {
        return recordID;
    }

    public void setRecordID(long recordID) {
        this.recordID = recordID;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(String corporationName) {
        this.corporationName = corporationName;
    }

}
