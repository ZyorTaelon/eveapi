package com.beimin.eveapi.parser.eve;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.eve.CharacterInfoHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;

public class CharacterInfoParser extends AbstractApiParser<CharacterInfoResponse> {
	public CharacterInfoParser() {
		super(CharacterInfoResponse.class, 2, ApiPath.EVE, ApiPage.CHARACTER_INFO);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new CharacterInfoHandler();
	}

	public CharacterInfoResponse getResponse(long characterID) throws ApiException {
		return super.getResponse("characterID", Long.toString(characterID));
	}

	@Override
	public CharacterInfoResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}