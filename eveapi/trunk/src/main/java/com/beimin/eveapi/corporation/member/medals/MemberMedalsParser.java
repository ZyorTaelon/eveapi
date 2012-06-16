package com.beimin.eveapi.corporation.member.medals;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class MemberMedalsParser extends AbstractListParser<MemberMedalsHandler, MemberMedalsResponse, MemberMedal> {
	public MemberMedalsParser() {
		super(MemberMedalsResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_MEDALS, MemberMedalsHandler.class);
	}

	public static MemberMedalsParser getInstance() {
		return new MemberMedalsParser();
	}

	@Override
	public MemberMedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}