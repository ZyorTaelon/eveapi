package com.beimin.eveapi.corporation.member.security;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class MemberSecurityParser extends AbstractApiParser<MemberSecurityResponse> {
	public MemberSecurityParser() {
		super(MemberSecurityResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_SECURITY);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new MemberSecurityHandler();
	}

	@Override
	public MemberSecurityResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}