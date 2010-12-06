package com.beimin.eveapi.corporation.member.tracking;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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
	public MemberTrackingResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}