package com.beimin.eveapi.model.shared;

import java.text.NumberFormat;
import java.util.Locale;

public class EveAccountBalance {
    private int accountID;
    private int accountKey;
    private double balance;

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(final int accountID) {
        this.accountID = accountID;
    }

    public int getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(final int accountKey) {
        this.accountKey = accountKey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(accountID);
        result.append("\t");
        result.append(accountKey);
        result.append("\t");
        final NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("is", "IS"));
        result.append(formatter.format(balance));
        return result.toString();
    }
}
