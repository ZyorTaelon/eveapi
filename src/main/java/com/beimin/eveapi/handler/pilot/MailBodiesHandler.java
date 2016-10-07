package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.MailBody;
import com.beimin.eveapi.response.pilot.MailBodiesResponse;

public class MailBodiesHandler extends AbstractContentListHandler<MailBodiesResponse, MailBody> {
    private MailBody mailBody;

    public MailBodiesHandler() {
        super(MailBodiesResponse.class);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (qName.equals("row")) {
            mailBody = getItem(attrs);
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (qName.equals("row")) {
            mailBody.setBody(getString());
            response.add(mailBody);
            mailBody = null;
            accumulator.setLength(0);
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    protected MailBody getItem(final Attributes attrs) {
        final MailBody item = new MailBody();
        saveFieldsCount(MailBody.class, attrs);
        item.setMessageID(getLong(attrs, "messageID"));
        return item;
    }
}