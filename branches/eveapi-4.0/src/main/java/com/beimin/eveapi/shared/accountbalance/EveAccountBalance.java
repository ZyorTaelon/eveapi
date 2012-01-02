package com.beimin.eveapi.shared.accountbalance;

public class EveAccountBalance {
	private int accountID;
	private int accountKey;
	private double balance;

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(int accountKey) {
		this.accountKey = accountKey;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}