package com.beimin.eveapi.character.medals;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class MedalsParser extends AbstractListParser<MedalsHandler, CharacterMedalsResponse, CharacterMedal> {
	public MedalsParser() {
		super(CharacterMedalsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MEDALS, MedalsHandler.class);
	}

	@Override
	public CharacterMedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}