package com.beimin.eveapi.handler;

import org.xml.sax.SAXException;

import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.response.ServerStatusResponse;

public class ServerStatusHandler extends AbstractContentHandler {
    private ServerStatusResponse response;

    @Override
    public void startDocument() throws SAXException {
        response = new ServerStatusResponse();
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if ("serverOpen".equals(qName)) {
            response.setServerOpen(getBoolean());
        } else if ("onlinePlayers".equals(qName)) {
            response.setOnlinePlayers(getInt());
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public ApiResponse getResponse() {
        return response;
    }
}