package com.beimin.eveapi.corporation.member.tracking;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MemberTrackingParser extends AbstractApiParser<MemberTrackingResponse> {
	protected static final String MEMBER_TRACKING_URL = "/corp/MemberTracking";

	public MemberTrackingParser() {
		super(MemberTrackingResponse.class, 2, MEMBER_TRACKING_URL);
	}

	public MemberTrackingResponse getMembers(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
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
}