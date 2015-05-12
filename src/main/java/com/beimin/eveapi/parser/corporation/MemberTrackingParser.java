package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.MemberTrackingHandler;
import com.beimin.eveapi.model.corporation.Member;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.MemberTrackingResponse;

public class MemberTrackingParser extends AbstractListParser<MemberTrackingHandler, MemberTrackingResponse, Member> {
	public MemberTrackingParser() {
		super(MemberTrackingResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_TRACKING,
				MemberTrackingHandler.class);
	}

	@Override
	public MemberTrackingResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}

	public MemberTrackingResponse getExtendedResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth, "extended", "1");
	}
}