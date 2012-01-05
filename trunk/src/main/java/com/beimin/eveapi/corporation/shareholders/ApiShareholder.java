package com.beimin.eveapi.corporation.shareholders;


public class ApiShareholder {
	private long shareholderID;
	private String shareholderName;
	private Long shareholderCorporationID;
	private String shareholderCorporationName;
	private int shares;

	public long getShareholderID() {
		return shareholderID;
	}

	public void setShareholderID(long shareholderID) {
		this.shareholderID = shareholderID;
	}

	public String getShareholderName() {
		return shareholderName;
	}

	public void setShareholderName(String shareholderName) {
		this.shareholderName = shareholderName;
	}

	public Long getShareholderCorporationID() {
		return shareholderCorporationID;
	}

	public void setShareholderCorporationID(Long shareholderCorporationID) {
		this.shareholderCorporationID = shareholderCorporationID;
	}

	public String getShareholderCorporationName() {
		return shareholderCorporationName;
	}

	public void setShareholderCorporationName(String shareholderCorporationName) {
		this.shareholderCorporationName = shareholderCorporationName;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}
}