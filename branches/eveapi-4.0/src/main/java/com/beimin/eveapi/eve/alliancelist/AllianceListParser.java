package com.beimin.eveapi.eve.alliancelist;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class AllianceListParser extends AbstractListParser<AllianceListResponse, ApiAlliance> {
	public AllianceListParser() {
		super(AllianceListResponse.class, 2, ApiPath.EVE, ApiPage.ALLIANCE_LIST, ApiAlliance.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiMemberCorporation.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "add");
		return digester;
	}

	public static AllianceListParser getInstance() {
		return new AllianceListParser();
	}

	@Override
	public AllianceListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}