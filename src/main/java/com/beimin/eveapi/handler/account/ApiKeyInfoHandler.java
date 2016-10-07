package com.beimin.eveapi.handler.account;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.account.ApiKeyInfo;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.model.shared.KeyType;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;

public class ApiKeyInfoHandler extends AbstractContentHandler {
    private ApiKeyInfoResponse response;
    private ApiKeyInfo apiKeyInfo;

    @Override
    public void startDocument() throws SAXException {
        response = new ApiKeyInfoResponse();
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (qName.equals("result")) {
            apiKeyInfo = new ApiKeyInfo();
        }
        if (qName.equals("key")) {
            for (int i = 0; i < attrs.getLength(); i++) {
                System.out.println(attrs.getQName(i));
            }
            saveFieldsCount(ApiKeyInfo.class, attrs);
            apiKeyInfo.setAccessMask(getLong(attrs, "accessMask"));
            apiKeyInfo.setType(KeyType.valueOf(getString(attrs, "type")));
            final String expires = attrs.getValue("expires").trim();
            if (expires.length() > 0) {
                apiKeyInfo.setExpires(getDate(expires));
            }
        } else if (qName.equals("row")) {
            saveFieldsCount(Character.class, attrs);
            final Character character = new Character();
            character.setCharacterID(getLong(attrs, "characterID"));
            character.setName(getString(attrs, "characterName"));
            character.setCorporationID(getLong(attrs, "corporationID"));
            character.setCorporationName(getString(attrs, "corporationName"));
            character.setAllianceID(getLong(attrs, "allianceID"));
            character.setAllianceName(getString(attrs, "allianceName"));
            character.setFactionID(getLong(attrs, "factionID"));
            character.setFactionName(getString(attrs, "factionName"));
            apiKeyInfo.addEveCharacter(character);
        } else if (qName.equals("result")) {
            response.set(apiKeyInfo);
        }
        super.startElement(uri, localName, qName, attrs);
        accumulator.setLength(0);
    }

    @Override
    public ApiKeyInfoResponse getResponse() {
        return response;
    }
}