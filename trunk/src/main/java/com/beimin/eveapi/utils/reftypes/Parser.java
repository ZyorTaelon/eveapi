package com.beimin.eveapi.utils.reftypes;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String REFTYPES_LIST_URL = "/eve/RefTypes.xml.aspx";

	public Parser() {
		super(Response.class, 1, REFTYPES_LIST_URL);
	}

	public Response getRefTypes() throws IOException, SAXException {
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

	public static Parser getInstance() {
		return new Parser();
	}
}
