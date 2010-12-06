package com.beimin.eveapi.corporation.member.medals;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class MemberMedalsParser extends AbstractApiParser<MemberMedalsResponse> {
	public MemberMedalsParser() {
		super(MemberMedalsResponse.class, 2, ApiPath.CORPORATION, ApiPage.MEMBER_MEDALS);
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

	@Override
	public MemberMedalsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}