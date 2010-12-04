package com.beimin.eveapi.account.characters;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class CharactersParser extends AbstractApiParser<CharactersResponse> {
	public CharactersParser() {
		super(CharactersResponse.class, 1, ApiPath.ACCOUNT, ApiPage.CHARACTERS);
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

	public CharactersResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}