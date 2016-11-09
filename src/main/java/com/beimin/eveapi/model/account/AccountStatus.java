package com.beimin.eveapi.model.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountStatus {
    private Date paidUntil;
    private Date createDate;
    private int logonCount;
    private int logonMinutes;
    private final List<Date> multiCharacterTraining = new ArrayList<>();
    private final List<Offer> offers = new ArrayList<>(); // Untested

    public Date getPaidUntil() {
        return paidUntil;
    }

    public void setPaidUntil(final Date paidUntil) {
        this.paidUntil = paidUntil;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public int getLogonCount() {
        return logonCount;
    }

    public void setLogonCount(final int logonCount) {
        this.logonCount = logonCount;
    }

    public int getLogonMinutes() {
        return logonMinutes;
    }

    public void setLogonMinutes(final int logonMinutes) {
        this.logonMinutes = logonMinutes;
    }

    // Untested
    public List<Date> getMultiCharacterTraining() {
        return multiCharacterTraining;
    }

    public void addMultiCharacterTraining(Date date) {
        this.multiCharacterTraining.add(date);
    }

    // Untested
    public List<Offer> getOffers() {
        return offers;
    }

    public void addOffers(Offer offer) {
        offers.add(offer);
    }
}
