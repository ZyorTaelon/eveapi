package com.beimin.eveapi.eve.reftypes;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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

	public RefTypesResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}