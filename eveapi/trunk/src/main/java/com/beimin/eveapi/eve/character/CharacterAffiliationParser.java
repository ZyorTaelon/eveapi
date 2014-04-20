package com.beimin.eveapi.eve.character;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.StringUtils;

public class CharacterAffiliationParser extends AbstractListParser<CharacterAffiliationHandler, CharacterAffiliationResponse, CharacterAffiliation> {
	public CharacterAffiliationParser() {
		super(CharacterAffiliationResponse.class, 2, ApiPath.EVE, ApiPage.CHARACTER_AFFILIATION, CharacterAffiliationHandler.class);
	}

	public CharacterAffiliationResponse getResponse(long... arguments) throws ApiException {
		return super.getResponse("ids", StringUtils.join(",", arguments));
	}
}