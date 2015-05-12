package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.pilot.CharacterSheetHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;

public class CharacterSheetParser extends AbstractApiParser<CharacterSheetResponse> {
	public CharacterSheetParser() {
		super(CharacterSheetResponse.class, 1, ApiPath.CHARACTER, ApiPage.CHARACTER_SHEET);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new CharacterSheetHandler();
	}

	@Override
	public CharacterSheetResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}