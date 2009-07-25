package com.beimin.eveapi.utils.alliancelist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String ALLIANCE_LIST_URL = "/eve/AllianceList.xml.aspx";

	public Parser() {
		super(Response.class, 1, ALLIANCE_LIST_URL);
	}

	public Response getAllianceList() throws IOException, SAXException {
		return getResponse();
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

	public static Parser getInstance() {
		return new Parser();
	}
}
