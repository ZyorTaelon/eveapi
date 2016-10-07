package com.beimin.eveapi.model.eve;

public class RefType {
    private int refTypeID; // ="0"
    private String refTypeName; // ="Undefined"

    public int getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(final int refTypeID) {
        this.refTypeID = refTypeID;
    }

    public String getRefTypeName() {
        return refTypeName;
    }

    public void setRefTypeName(final String refTypeName) {
        this.refTypeName = refTypeName;
    }
}