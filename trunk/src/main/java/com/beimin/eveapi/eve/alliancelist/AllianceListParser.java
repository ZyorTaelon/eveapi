package com.beimin.eveapi.eve.alliancelist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class AllianceListParser extends AbstractApiParser<AllianceListResponse> {
	public AllianceListParser() {
		super(AllianceListResponse.class, 1, ApiPath.EVE, ApiPage.ALLIANCE_LIST);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiAlliance.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiMemberCorporation.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addMemberCorporation");
		digester.addSetNext("eveapi/result/rowset/row", "addAlliance");
		return digester;
	}

	public static AllianceListParser getInstance() {
		return new AllianceListParser();
	}

	@Override
	public AllianceListResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}