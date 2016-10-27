package com.beimin.eveapi.model.account;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AccountStatus {
    private Date paidUntil; // >2011-03-13 18:40:00</paidUntil>
    private Date createDate; // >2004-07-22 23:54:00</createDate>
    private int logonCount; // >5603</logonCount>
    private int logonMinutes; // >504903</logonMinutes>
    private final Set<Date> multiCharacterTraining = new HashSet<>();

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
}
