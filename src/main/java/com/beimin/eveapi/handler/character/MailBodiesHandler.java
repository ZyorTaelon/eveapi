package com.beimin.eveapi.handler.character;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.character.MailBody;
import com.beimin.eveapi.response.character.MailBodiesResponse;

public class MailBodiesHandler extends AbstractContentListHandler<MailBodiesResponse, MailBody> {

    public MailBodiesHandler() {
        super(new MailBodiesResponse());
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROW.equals(qName)) {
            setCurrentClass(MailBody.class);
            getItem().setBody(getString());
        }
    }

    @Override
    protected MailBody getItem(final Attributes attrs) {
        final MailBody item = new MailBody();
        saveAttributes(MailBody.class, attrs);
        item.setMessageID(getLong(attrs, "messageID"));
        return item;
    }
}
