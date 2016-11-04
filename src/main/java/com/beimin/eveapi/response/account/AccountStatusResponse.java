package com.beimin.eveapi.response.account;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.account.Offer;
import com.beimin.eveapi.response.ApiResponse;

public class AccountStatusResponse extends ApiResponse {
    private Date paidUntil;
    private Date createDate;
    private int logonCount;
    private int logonMinutes;
    private final Set<Date> multiCharacterTraining = new HashSet<>(); // Untested
    private final Set<Offer> offers = new HashSet<>(); // Untested

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

    public Set<Date> getMultiCharacterTraining() {
        return multiCharacterTraining;
    }

    public void addMultiCharacterTraining(Date date) {
        this.multiCharacterTraining.add(date);
    }

    // Untested
    public Set<Offer> getOffers() {
        return offers;
    }

    public void addOffers(Offer offer) {
        offers.add(offer);
    }
}
