package com.beimin.eveapi.character.medals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.beimin.eveapi.shared.medals.Medal;

public class CharacterMedal extends Medal {
	private String reason;
	private String status;
	private long issuerID;
	private String issued;
	private long corporationID;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

	public Date getIssuedDateTime() throws ParseException {
		return sdf.parse(issued);
	}

	public String getIssued() {
		return issued;
	}

	public void setIssued(String issued) {
		this.issued = issued;
	}

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}
}