package com.beimin.eveapi.corporation.medals;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class MedalsParser extends AbstractListParser<MedalsHandler, CorpMedalsResponse, CorpMedal> {
	private MedalsParser() {
		super(CorpMedalsResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEDALS, MedalsHandler.class);
	}

	public static MedalsParser getInstance() {
		return new MedalsParser();
	}

	@Override
	public CorpMedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}