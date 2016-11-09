package com.beimin.eveapi.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.response.ApiListResponse;

public abstract class AbstractContentListHandler<E extends ApiListResponse<B>, B> extends AbstractContentHandler<E> {
    private B item;

    public AbstractContentListHandler(E response) {
        super(response);
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROW.equals(qName)) {
            item = getItem(attrs);
            getResponse().add(item);
        }
    }

    public B getItem() {
        return item;
    }

    protected abstract B getItem(Attributes attrs);
}
