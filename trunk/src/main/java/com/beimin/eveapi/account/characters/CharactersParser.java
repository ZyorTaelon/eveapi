package com.beimin.eveapi.account.characters;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class CharactersParser extends AbstractApiParser<CharactersResponse> {
	protected static final String CHARACTER_LIST_URL = "/Characters.xml.aspx";

	public CharactersParser() {
		super(CharactersResponse.class, 1, CHARACTER_LIST_URL);
	}

	public CharactersResponse getEveCharacters(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.ACCOUNT);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiCharacter.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addEveCharacter");
		return digester;
	}

	public static CharactersParser getInstance() {
		return new CharactersParser();
	}
}