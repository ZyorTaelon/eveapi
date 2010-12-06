package com.beimin.eveapi.map.factwar.systems;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class FacWarSystemsParser extends AbstractApiParser<FacWarSystemsResponse> {
	private FacWarSystemsParser() {
		super(FacWarSystemsResponse.class, 2, ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiFacWarSystem.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystem");
		return digester;
	}

	public static FacWarSystemsParser getInstance() {
		return new FacWarSystemsParser();
	}

	@Override
	public FacWarSystemsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}