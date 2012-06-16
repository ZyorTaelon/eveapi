package com.beimin.eveapi.corporation.member.medals;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

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
	public MemberMedalsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}