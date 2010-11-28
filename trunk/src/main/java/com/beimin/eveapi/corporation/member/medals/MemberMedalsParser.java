package com.beimin.eveapi.corporation.member.medals;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MemberMedalsParser extends AbstractApiParser<MemberMedalsResponse> {
	protected static final String MEMBER_MEDALS_URL = "/MemberMedals.xml.aspx";

	public MemberMedalsParser() {
		super(MemberMedalsResponse.class, 2, MEMBER_MEDALS_URL);
	}

	public MemberMedalsResponse getKillList(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CORPORATION);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", MemberMedal.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMedal");
		return digester;
	}

	public static MemberMedalsParser getInstance() {
		return new MemberMedalsParser();
	}
}