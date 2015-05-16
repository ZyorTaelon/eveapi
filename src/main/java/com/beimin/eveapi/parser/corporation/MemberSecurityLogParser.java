package com.beimin.eveapi.parser.corporation;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.MemberSecurityLogHandler;
import com.beimin.eveapi.model.corporation.RoleHistory;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.MemberSecurityLogResponse;

public class MemberSecurityLogParser extends AbstractListParser<MemberSecurityLogHandler, MemberSecurityLogResponse, RoleHistory> {
	public MemberSecurityLogParser() {
		super(MemberSecurityLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_SECURITY_LOG, MemberSecurityLogHandler.class);
	}

	@Override
	public MemberSecurityLogResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}