package com.beimin.eveapi.handler.account;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.account.AccountStatus;
import com.beimin.eveapi.response.account.AccountStatusResponse;

public class AccountStatusHandler extends AbstractContentHandler {
    private AccountStatusResponse response;
    private AccountStatus accountStatus;

    @Override
    public void startDocument() throws SAXException {
        response = new AccountStatusResponse();
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        if ("result".equals(qName)) {
            accountStatus = new AccountStatus();
        }
        super.startElement(uri, localName, qName, attributes);
        accumulator.setLength(0);
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if ("userID".equals(qName)) {
            accountStatus.setUserID(getInt());
        } else if ("paidUntil".equals(qName)) {
            accountStatus.setPaidUntil(getDate());
        } else if ("createDate".equals(qName)) {
            accountStatus.setCreateDate(getDate());
        } else if ("logonCount".equals(qName)) {
            accountStatus.setLogonCount(getInt());
        } else if ("logonMinutes".equals(qName)) {
            accountStatus.setLogonMinutes(getInt());
        } else if ("result".equals(qName)) {
            response.set(accountStatus);
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public AccountStatusResponse getResponse() {
        return response;
    }
}
