package com.beimin.eveapi.journal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JournalEntry {
	private String date;
	private long refID;
	private long refTypeID;
	private String ownerName1;
	private long ownerID1;
	private String ownerName2;
	private long ownerID2;
	private String argName1;
	private long argID1;
	private double amount;
	private double balance;
	private String reason;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHS:mm:ss");

	public Date getDateTime() throws ParseException {
		return sdf.parse(date);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getRefID() {
		return refID;
	}

	public void setRefID(long refID) {
		this.refID = refID;
	}

	public long getRefTypeID() {
		return refTypeID;
	}

	public void setRefTypeID(long refTypeID) {
		this.refTypeID = refTypeID;
	}

	public String getOwnerName1() {
		return ownerName1;
	}

	public void setOwnerName1(String ownerName1) {
		this.ownerName1 = ownerName1;
	}

	public long getOwnerID1() {
		return ownerID1;
	}

	public void setOwnerID1(long ownerID1) {
		this.ownerID1 = ownerID1;
	}

	public String getOwnerName2() {
		return ownerName2;
	}

	public void setOwnerName2(String ownerName2) {
		this.ownerName2 = ownerName2;
	}

	public long getOwnerID2() {
		return ownerID2;
	}

	public void setOwnerID2(long ownerID2) {
		this.ownerID2 = ownerID2;
	}

	public String getArgName1() {
		return argName1;
	}

	public void setArgName1(String argName1) {
		this.argName1 = argName1;
	}

	public long getArgID1() {
		return argID1;
	}

	public void setArgID1(long argID1) {
		this.argID1 = argID1;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}