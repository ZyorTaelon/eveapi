package com.beimin.eveapi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.response.ApiListResponse;

public abstract class AbstractContentListHandler<E extends ApiListResponse<B>, B> extends AbstractContentHandler<E> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractContentListHandler.class);

    private final Class<E> clazz;

    public AbstractContentListHandler(final Class<E> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public void startDocument() throws SAXException {
        try {
            setResponse(clazz.newInstance());
        } catch (final InstantiationException | IllegalAccessException e) {
            LOGGER.error("Could't start document", e);
        }
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROW.equals(qName)) {
            getResponse().add(getItem(attrs));
        }
        super.startElement(uri, localName, qName, attrs);
    }

    protected abstract B getItem(Attributes attrs);
}
