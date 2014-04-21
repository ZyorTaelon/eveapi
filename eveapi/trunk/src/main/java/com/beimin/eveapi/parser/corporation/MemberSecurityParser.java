package com.beimin.eveapi.parser.corporation;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.corporation.MemberSecurityHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.corporation.MemberSecurityResponse;

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