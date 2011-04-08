package com.beimin.eveapi.corporation.outpost.servicedetail;


public class ApiOutpostServiceDetail {
	private int stationID;//="61000244" 
	private long ownerID;//="773499566" 
	private String serviceName;//="Reprocessing Plant" 
	private double minStanding;//="2" 
	private double surchargePerBadStanding;//="10" 
	private double discountPerGoodStanding;//="0"

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getMinStanding() {
		return minStanding;
	}

	public void setMinStanding(double minStanding) {
		this.minStanding = minStanding;
	}

	public double getSurchargePerBadStanding() {
		return surchargePerBadStanding;
	}

	public void setSurchargePerBadStanding(double surchargePerBadStanding) {
		this.surchargePerBadStanding = surchargePerBadStanding;
	}

	public double getDiscountPerGoodStanding() {
		return discountPerGoodStanding;
	}

	public void setDiscountPerGoodStanding(double discountPerGoodStanding) {
		this.discountPerGoodStanding = discountPerGoodStanding;
	}
}