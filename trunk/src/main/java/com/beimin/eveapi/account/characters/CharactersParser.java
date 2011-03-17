package com.beimin.eveapi.account.characters;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

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

	@Override
	public CharactersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}