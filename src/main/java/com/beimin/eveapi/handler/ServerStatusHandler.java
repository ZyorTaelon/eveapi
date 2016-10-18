package com.beimin.eveapi.handler;

import org.xml.sax.SAXException;

import com.beimin.eveapi.response.ServerStatusResponse;

public class ServerStatusHandler extends AbstractContentHandler<ServerStatusResponse> {
    @Override
    public void startDocument() throws SAXException {
        setResponse(new ServerStatusResponse());
    }

    @Override
    public void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if ("serverOpen".equals(qName)) {
            getResponse().setServerOpen(getBoolean());
        } else if ("onlinePlayers".equals(qName)) {
            getResponse().setOnlinePlayers(getInt());
        }
    }
}
