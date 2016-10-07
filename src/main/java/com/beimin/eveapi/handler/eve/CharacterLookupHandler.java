package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.eve.CharacterLookup;
import com.beimin.eveapi.response.eve.CharacterLookupResponse;

public class CharacterLookupHandler extends AbstractContentListHandler<CharacterLookupResponse, CharacterLookup> {

    public CharacterLookupHandler() {
        super(CharacterLookupResponse.class);
    }

    @Override
    protected CharacterLookup getItem(final Attributes attrs) {
        final CharacterLookup lookup = new CharacterLookup();
        saveFieldsCount(CharacterLookup.class, attrs);
        lookup.setCharacterID(getLong(attrs, "characterID"));
        lookup.setName(getString(attrs, "name"));
        return lookup;
    }
}