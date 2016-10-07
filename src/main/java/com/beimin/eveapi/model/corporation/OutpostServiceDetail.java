package com.beimin.eveapi.model.corporation;

public class OutpostServiceDetail {
    private long stationID;
    private long ownerID;
    private String serviceName;
    private double minStanding;
    private double surchargePerBadStanding;
    private double discountPerGoodStanding;

    public long getStationID() {
        return stationID;
    }

    public void setStationID(final long stationID) {
        this.stationID = stationID;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(final long ownerID) {
        this.ownerID = ownerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(final String serviceName) {
        this.serviceName = serviceName;
    }

    public double getMinStanding() {
        return minStanding;
    }

    public void setMinStanding(final double minStanding) {
        this.minStanding = minStanding;
    }

    public double getSurchargePerBadStanding() {
        return surchargePerBadStanding;
    }

    public void setSurchargePerBadStanding(final double surchargePerBadStanding) {
        this.surchargePerBadStanding = surchargePerBadStanding;
    }

    public double getDiscountPerGoodStanding() {
        return discountPerGoodStanding;
    }

    public void setDiscountPerGoodStanding(final double discountPerGoodStanding) {
        this.discountPerGoodStanding = discountPerGoodStanding;
    }
}
