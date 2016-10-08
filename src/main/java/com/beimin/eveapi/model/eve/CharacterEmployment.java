package com.beimin.eveapi.model.eve;

import java.util.Date;

public class CharacterEmployment {
    private Long corporationID;
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

}
