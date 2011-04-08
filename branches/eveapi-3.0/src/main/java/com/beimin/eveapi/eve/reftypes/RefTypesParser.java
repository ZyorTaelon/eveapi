package com.beimin.eveapi.eve.reftypes;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class RefTypesParser extends AbstractApiParser<RefTypesResponse> {
	public RefTypesParser() {
		super(RefTypesResponse.class, 1, ApiPath.EVE, ApiPage.REF_TYPES);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiRefType.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addRefType");
		return digester;
	}

	public static RefTypesParser getInstance() {
		return new RefTypesParser();
	}

	@Override
	public RefTypesResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}