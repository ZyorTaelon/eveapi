package com.beimin.eveapi.parser.eve;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.eve.CharacterAffiliationHandler;
import com.beimin.eveapi.model.eve.CharacterAffiliation;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.eve.CharacterAffiliationResponse;
import com.beimin.eveapi.utils.StringUtils;

public class CharacterAffiliationParser extends AbstractListParser<CharacterAffiliationHandler, CharacterAffiliationResponse, CharacterAffiliation> {
	public CharacterAffiliationParser() {
		super(CharacterAffiliationResponse.class, 2, ApiPath.EVE, ApiPage.CHARACTER_AFFILIATION, CharacterAffiliationHandler.class);
	}

	public CharacterAffiliationResponse getResponse(long... arguments) throws ApiException {
		return super.getResponse("ids", StringUtils.join(",", arguments));
	}
}