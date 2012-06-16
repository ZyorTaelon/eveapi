package com.beimin.eveapi.character.sheet;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CharacterSheetParser extends AbstractApiParser<CharacterSheetResponse> {
	public CharacterSheetParser() {
		super(CharacterSheetResponse.class, 1, ApiPath.CHARACTER, ApiPage.CHARACTER_SHEET);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new CharacterSheetHandler();
	}

	public static CharacterSheetParser getInstance() {
		return new CharacterSheetParser();
	}

	@Override
	public CharacterSheetResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}