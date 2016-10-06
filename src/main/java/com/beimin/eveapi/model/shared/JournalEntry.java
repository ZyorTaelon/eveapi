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

    public int compareTo(JournalEntry o) {
        return Long.compare(this.getRefID(), o.getRefID());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (argID1 ^ (argID1 >>> 32));
        result = prime * result + ((argName1 == null) ? 0 : argName1.hashCode());
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + (int) (ownerID1 ^ (ownerID1 >>> 32));
        result = prime * result + (int) (ownerID2 ^ (ownerID2 >>> 32));
        result = prime * result + ((ownerName1 == null) ? 0 : ownerName1.hashCode());
        result = prime * result + ((ownerName2 == null) ? 0 : ownerName2.hashCode());
        result = prime * result + ((reason == null) ? 0 : reason.hashCode());
        result = prime * result + (int) (refID ^ (refID >>> 32));
        result = prime * result + ((refType == null) ? 0 : refType.hashCode());
        result = prime * result + refTypeID;
        result = prime * result + ((taxAmount == null) ? 0 : taxAmount.hashCode());
        result = prime * result + ((taxReceiverID == null) ? 0 : taxReceiverID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JournalEntry other = (JournalEntry) obj;
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (argID1 != other.argID1)
            return false;
        if (argName1 == null) {
            if (other.argName1 != null)
                return false;
        } else if (!argName1.equals(other.argName1))
            return false;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (ownerID1 != other.ownerID1)
            return false;
        if (ownerID2 != other.ownerID2)
            return false;
        if (ownerName1 == null) {
            if (other.ownerName1 != null)
                return false;
        } else if (!ownerName1.equals(other.ownerName1))
            return false;
        if (ownerName2 == null) {
            if (other.ownerName2 != null)
                return false;
        } else if (!ownerName2.equals(other.ownerName2))
            return false;
        if (reason == null) {
            if (other.reason != null)
                return false;
        } else if (!reason.equals(other.reason))
            return false;
        if (refID != other.refID)
            return false;
        if (refType != other.refType)
            return false;
        if (refTypeID != other.refTypeID)
            return false;
        if (taxAmount == null) {
            if (other.taxAmount != null)
                return false;
        } else if (!taxAmount.equals(other.taxAmount))
            return false;
        if (taxReceiverID == null) {
            if (other.taxReceiverID != null)
                return false;
        } else if (!taxReceiverID.equals(other.taxReceiverID))
            return false;
        return true;
    }
}