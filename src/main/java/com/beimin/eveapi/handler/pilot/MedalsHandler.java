package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.Medal;
import com.beimin.eveapi.response.pilot.MedalsResponse;

public class MedalsHandler extends AbstractContentListHandler<MedalsResponse, Medal> {
    private String rowsetName;

    public MedalsHandler() {
        super(MedalsResponse.class);
    }

    @Override
    protected void elementStart(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            rowsetName = getString(attrs, ATTRIBUTE_NAME);
        }
        super.elementStart(uri, localName, qName, attrs);
    }

    @Override
    protected void elementEnd(String uri, String localName, String qName) throws SAXException {
        if (ELEMENT_ROW.equals(qName)) {
            if ("currentCorporation".equals(rowsetName)) {
                getResponse().addCurrentCorporation(getItem());
            } else if ("otherCorporations".equals(rowsetName)) {
                getResponse().addOtherCorporations(getItem());
            }
        }
    }

    @Override
    protected Medal getItem(final Attributes attrs) {
        final Medal medal = new Medal();
        saveAttributes(Medal.class, attrs);
        medal.setMedalID(getInt(attrs, "medalID"));
        medal.setCorporationID(getLong(attrs, "corporationID"));
        medal.setDescription(getString(attrs, "description"));
        medal.setIssued(getDate(attrs, "issued"));
        medal.setIssuerID(getLong(attrs, "issuerID"));
        medal.setReason(getString(attrs, "reason"));
        medal.setStatus(getString(attrs, "status"));
        medal.setTitle(getString(attrs, "title"));
        return medal;
    }
}
