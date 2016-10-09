package com.beimin.eveapi.handler.account;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.response.account.CharactersResponse;

public class CharactersHandler extends AbstractContentListHandler<CharactersResponse, Character> {
    public CharactersHandler() {
        super(CharactersResponse.class);
    }

    @Override
    protected Character getItem(final Attributes attrs) {
        final Character character = new Character();
        saveFieldsCount(Character.class, attrs);
        character.setCharacterID(getLong(attrs, "characterID"));
        character.setName(getString(attrs, "name"));
        character.setCorporationID(getLong(attrs, "corporationID"));
        character.setCorporationName(getString(attrs, "corporationName"));
        character.setAllianceID(getLong(attrs, "allianceID"));
        character.setAllianceName(getString(attrs, "allianceName"));
        character.setFactionID(getLong(attrs, "factionID"));
        character.setFactionName(getString(attrs, "factionName"));
        return character;
    }
}
