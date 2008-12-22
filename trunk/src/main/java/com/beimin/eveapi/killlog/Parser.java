package com.beimin.eveapi.killlog;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String JOURNAL_URL = "/KillList.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getKillList(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		if (corporation)
			requestUrl += CORP_PATH;
		else
			requestUrl += CHAR_PATH;
		requestUrl += JOURNAL_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=1";
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", Kill.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addObjectCreate("eveapi/result/rowset/row/victim", Victim.class);
		digester.addSetProperties("eveapi/result/rowset/row/victim");
		digester.addSetNext("eveapi/result/rowset/row/victim", "setVictim");

		digester.addFactoryCreate("eveapi/result/rowset/row/rowset/row", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("characterID") != null)
					return new Attacker();
				if (attributes.getValue("typeID") != null)
					return new Item();
				return null;
			}
		});
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addKillDetail");
		digester.addSetNext("eveapi/result/rowset/row", "addKill");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}