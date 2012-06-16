package com.beimin.eveapi.eve.character;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CharacterInfoParser extends AbstractApiParser<CharacterInfoResponse> {
	public CharacterInfoParser() {
		super(CharacterInfoResponse.class, 2, ApiPath.EVE, ApiPage.CHARACTER_INFO);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new CharacterInfoHandler();
	}

	public static CharacterInfoParser getInstance() {
		return new CharacterInfoParser();
	}

	public CharacterInfoResponse getResponse(long characterID) throws ApiException {
		return super.getResponse("characterID", Long.toString(characterID));
	}

	@Override
	public CharacterInfoResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}