package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.MemberMedalsHandler;
import com.beimin.eveapi.model.corporation.MemberMedal;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.MemberMedalsResponse;

public class MemberMedalsParser extends AbstractListParser<MemberMedalsHandler, MemberMedalsResponse, MemberMedal> {
	public MemberMedalsParser() {
		super(MemberMedalsResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_MEDALS, MemberMedalsHandler.class);
	}

	@Override
	public MemberMedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}