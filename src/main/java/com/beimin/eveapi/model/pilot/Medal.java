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

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isPublic() {
		return status.equals("public");
	}

	public long getIssuerID() {
		return issuerID;
	}

	public void setIssuerID(long issuerID) {
		this.issuerID = issuerID;
	}

	public Date getIssued() {
		return issued;
	}

	public void setIssued(Date issued) {
		this.issued = issued;
	}

	public Long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(Long corporationID) {
		this.corporationID = corporationID;
	}
}