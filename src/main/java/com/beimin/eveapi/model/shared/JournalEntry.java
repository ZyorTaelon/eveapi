package com.beimin.eveapi.model.shared;

import java.util.Date;

public class JournalEntry implements Comparable<JournalEntry> {
	private Date date;
	private long refID;
	private int refTypeID;
	private RefType refType;
	private String ownerName1;
	private long ownerID1;
	private String ownerName2;
	private long ownerID2;
	private String argName1;
	private long argID1;
	private double amount;
	private double balance;
	private String reason;
	private Long taxReceiverID;
	private Double taxAmount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getRefID() {
		return refID;
	}

	public void setRefID(long refID) {
		this.refID = refID;
	}

	public void setRefTypeID(int refTypeID) {
		this.refTypeID = refTypeID;
		refType = RefType.forID(refTypeID);
	}

	public int getRefTypeID() {
		return refTypeID;
	}

	public RefType getRefType() {
		return refType;
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

	public Long getTaxReceiverID() {
		return taxReceiverID;
	}

	public void setTaxReceiverID(Long taxReceiverID) {
		this.taxReceiverID = taxReceiverID;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	// public static Map<Integer, Map<String, String>> getRefTypes() {
	// Map<Integer, Map<String, String>> refTypes = new HashMap<Integer,
	// Map<String, String>>();
	// Map<String, String> meaning = new HashMap<String, String>();
	// meaning.put("RefTypeName", "Player Trading");
	// meaning.put("argName1", "Station name");
	// meaning.put("argID1", "Station ID");
	// refTypes.put(1, meaning);
	// // 1 Player Trading Station name Station ID arg describes where the
	// // direct player trade took place. See staStations table.
	// meaning = new HashMap<String, String>();
	// meaning.put("RefTypeName", "Market Transaction");
	// meaning.put("argName1", "transactionID");
	// meaning.put("argID1", "0");
	// refTypes.put(2, meaning);
	// // 2 Market Transaction transactionID 0 See MarketTransactions API
	// meaning = new HashMap<String, String>();
	// meaning.put("RefTypeName", "Player Donation");
	// meaning.put("argName1", "");
	// meaning.put("argID1", "0");
	// refTypes.put(10, meaning);
	// // 10 Player Donation 0 user-entered text The donating player is free to
	// // enter text with the transfer, which shows up in the reason column
	// // here.
	// meaning = new HashMap<String, String>();
	// meaning.put("RefTypeName", "Bounty Prize");
	// meaning.put("argName1", "NPC Name");
	// meaning.put("argID1", "NPC ID");
	// refTypes.put(17, meaning);
	// // 17 Bounty Prize NPC Name NPC ID This was replaced with refTypeID 85
	// // when Trinity was released.
	// meaning = new HashMap<String, String>();
	// meaning.put("RefTypeName", "Insurance");
	// meaning.put("argName1", "Destroyed ship's typeID");
	// meaning.put("argID1", "0");
	// refTypes.put(17, meaning);
	// // 19 Insurance Destroyed ship's typeID 0 See invTypes table.
	// meaning = new HashMap<String, String>();
	// meaning.put("RefTypeName", "Player name");
	// meaning.put("argName1", "Player characterID");
	// meaning.put("argID1", "0");
	// refTypes.put(35, meaning);
	// // 35 CSPA Player name Player characterID Player is the person whom
	// // you're trying to contact.
	// meaning = new HashMap<String, String>();
	// meaning.put("RefTypeName", "Manufacturing");
	// meaning.put("argName1", "Job ID");
	// meaning.put("argID1", "0");
	// refTypes.put(56, meaning);
	// // 56 Manufacturing Job ID 0 See Industry Jobs API.
	// return refTypes;
	// }

	public int compareTo(JournalEntry o) {
		return Math.round(this.getRefID() - o.getRefID());
	}
}