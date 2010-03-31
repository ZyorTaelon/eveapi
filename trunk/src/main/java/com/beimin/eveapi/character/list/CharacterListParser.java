package com.beimin.eveapi.character.list;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class CharacterListParser extends AbstractApiParser<CharacterListResponse> {
	protected static final String CHARACTER_LIST_URL = "/account/Characters.xml.aspx";

	public CharacterListParser() {
		super(CharacterListResponse.class, 1, CHARACTER_LIST_URL);
	}

	public CharacterListResponse getEveCharacters(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiCharacter.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addEveCharacter");
		return digester;
	}

	public static CharacterListParser getInstance() {
		return new CharacterListParser();
	}
}