package com.beimin.eveapi.corporation.member.tracking;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MemberTrackingParser extends AbstractListParser<MemberTrackingHandler, MemberTrackingResponse, ApiMember> {
	public MemberTrackingParser() {
		super(MemberTrackingResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_TRACKING,
				MemberTrackingHandler.class);
	}

	public static MemberTrackingParser getInstance() {
		return new MemberTrackingParser();
	}

	@Override
	public MemberTrackingResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}