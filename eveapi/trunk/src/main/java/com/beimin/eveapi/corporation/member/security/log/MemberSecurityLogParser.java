package com.beimin.eveapi.corporation.member.security.log;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class MemberSecurityLogParser extends AbstractListParser<MemberSecurityLogHandler, MemberSecurityLogResponse, ApiRoleHistory> {
	public MemberSecurityLogParser() {
		super(MemberSecurityLogResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_SECURITY_LOG, MemberSecurityLogHandler.class);
	}

	@Override
	public MemberSecurityLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}