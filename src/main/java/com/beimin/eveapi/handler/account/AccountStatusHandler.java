package com.beimin.eveapi.handler.account;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.account.AccountStatus;
import com.beimin.eveapi.response.account.AccountStatusResponse;

public class AccountStatusHandler extends AbstractContentHandler<AccountStatusResponse> {
    private AccountStatus accountStatus;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new AccountStatusResponse());
        saveFieldsCount(AccountStatus.class, 4);
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        if ("result".equals(qName)) {
            accountStatus = new AccountStatus();
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if ("paidUntil".equals(qName)) {
            accountStatus.setPaidUntil(getDate());
        } else if ("createDate".equals(qName)) {
            accountStatus.setCreateDate(getDate());
        } else if ("logonCount".equals(qName)) {
            accountStatus.setLogonCount(getInt());
        } else if ("logonMinutes".equals(qName)) {
            accountStatus.setLogonMinutes(getInt());
        } else if ("result".equals(qName)) {
            getResponse().set(accountStatus);
        }
    }
}
