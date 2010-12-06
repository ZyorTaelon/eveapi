package com.beimin.eveapi.corporation.starbase.list;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class StarbaseListParser extends AbstractApiParser<StarbaseListResponse> {
	public StarbaseListParser() {
		super(StarbaseListResponse.class, 2, ApiPath.CORPORATION, ApiPage.STARBASE_LIST);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiStarbase.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addStarbase");
		return digester;
	}

	public static StarbaseListParser getInstance() {
		return new StarbaseListParser();
	}

	@Override
	public StarbaseListResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}