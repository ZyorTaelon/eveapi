package com.beimin.eveapi.character.medals;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MedalsParser extends AbstractListParser<CharacterMedalsResponse, CharacterMedal> {
	private MedalsParser() {
		super(CharacterMedalsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MEDALS, CharacterMedal.class);
	}

	public static MedalsParser getInstance() {
		return new MedalsParser();
	}

	@Override
	public CharacterMedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}