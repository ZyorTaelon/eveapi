package com.beimin.eveapi.account.characters;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class CharactersParser extends AbstractListParser<CharactersHandler, CharactersResponse, EveCharacter> {
	public CharactersParser() {
		super(CharactersResponse.class, 1, ApiPath.ACCOUNT, ApiPage.CHARACTERS, CharactersHandler.class);
	}

	public static CharactersParser getInstance() {
		return new CharactersParser();
	}

	@Override
	public CharactersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}