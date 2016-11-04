package com.beimin.eveapi.handler.account;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.account.Offer;
import com.beimin.eveapi.response.account.AccountStatusResponse;

public class AccountStatusHandler extends AbstractContentHandler<AccountStatusResponse> {
    private String rowsetName;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new AccountStatusResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attributes) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            rowsetName = getString(attributes, ATTRIBUTE_NAME);
        } else if (ELEMENT_ROW.equals(qName)) {
            if ("multiCharacterTraining".equals(rowsetName)) {
                getResponse().addMultiCharacterTraining(getDate(attributes, "trainingEnd"));
            } else if ("Offers".equals(rowsetName)) {
                Offer offer = new Offer();
                saveAttributes(Offer.class, attributes);
                offer.setOfferID(getLong(attributes, "offerID"));
                offer.setOfferedDate(getDate(attributes, "offeredDate"));
                offer.setFrom(getString(attributes, "from"));
                offer.setTo(getString(attributes, "to"));
                offer.setISK(getDouble(attributes, "ISK"));
                getResponse().addOffers(offer);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        AccountStatusResponse response = getResponse();
        if ("paidUntil".equals(qName)) {
            response.setPaidUntil(getDate());
        } else if ("createDate".equals(qName)) {
            response.setCreateDate(getDate());
        } else if ("logonCount".equals(qName)) {
            response.setLogonCount(getInt());
        } else if ("logonMinutes".equals(qName)) {
            response.setLogonMinutes(getInt());
        }
    }
}
