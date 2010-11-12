package com.beimin.eveapi.eve.reftypes;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class RefTypesParser extends AbstractApiParser<RefTypesResponse> {
	protected static final String REFTYPES_LIST_URL = "/eve/RefTypes.xml.aspx";

	public RefTypesParser() {
		super(RefTypesResponse.class, 1, REFTYPES_LIST_URL);
	}

	public RefTypesResponse getRefTypes() throws IOException, SAXException {
		return getResponse();
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
}
