package com.beimin.eveapi.corporation.member.tracking;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MemberTrackingParser extends AbstractApiParser<MemberTrackingResponse> {
	public MemberTrackingParser() {
		super(MemberTrackingResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_TRACKING);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMember.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMember");
		return digester;
	}

	public static MemberTrackingParser getInstance() {
		return new MemberTrackingParser();
	}

	@Override
	public MemberTrackingResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}