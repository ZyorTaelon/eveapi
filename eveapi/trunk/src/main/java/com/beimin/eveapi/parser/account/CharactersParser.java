package com.beimin.eveapi.parser.account;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.account.CharactersHandler;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.account.CharactersResponse;

public class CharactersParser extends AbstractListParser<CharactersHandler, CharactersResponse, Character> {
	public CharactersParser() {
		super(CharactersResponse.class, 1, ApiPath.ACCOUNT, ApiPage.CHARACTERS, CharactersHandler.class);
	}

	@Override
	public CharactersResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}