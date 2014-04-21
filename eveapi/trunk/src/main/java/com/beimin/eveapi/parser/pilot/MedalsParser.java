package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.pilot.MedalsHandler;
import com.beimin.eveapi.model.pilot.Medal;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.pilot.MedalsResponse;

public class MedalsParser extends AbstractListParser<MedalsHandler, MedalsResponse, Medal> {
	public MedalsParser() {
		super(MedalsResponse.class, 2, ApiPath.CHARACTER, ApiPage.MEDALS, MedalsHandler.class);
	}

	@Override
	public MedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}