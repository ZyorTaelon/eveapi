package com.beimin.eveapi.corporation.member.medals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberMedal {
	private int medalID;
	private long characterID;
	private String reason;
	private String status;
	private long issuerID;
	private String issued;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public int getMedalID() {
		return medalID;
	}

	public void setMedalID(int medalID) {
		this.medalID = medalID;
	}

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

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
}