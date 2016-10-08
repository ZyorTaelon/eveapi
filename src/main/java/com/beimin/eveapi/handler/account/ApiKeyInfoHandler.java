package com.beimin.eveapi.handler.account;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.account.ApiKeyInfo;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.model.shared.KeyType;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;

public class ApiKeyInfoHandler extends AbstractContentHandler<ApiKeyInfoResponse> {
    private ApiKeyInfo apiKeyInfo;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new ApiKeyInfoResponse());
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if ("result".equals(qName)) {
            apiKeyInfo = new ApiKeyInfo();
        }
        if ("key".equals(qName)) {
            apiKeyInfo.setAccessMask(getLong(attrs, "accessMask"));
            apiKeyInfo.setType(KeyType.valueOf(getString(attrs, "type")));
            final String expires = attrs.getValue("expires").trim();
            if (expires.length() > 0) {
                apiKeyInfo.setExpires(getDate(expires));
            }
        } else if (ELEMENT_ROW.equals(qName)) {
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
        } else if ("result".equals(qName)) {
            getResponse().set(apiKeyInfo);
        }
        super.startElement(uri, localName, qName, attrs);
        accumulator.setLength(0);
    }
}
