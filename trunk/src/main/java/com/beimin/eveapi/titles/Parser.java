package com.beimin.eveapi.titles;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String CORPORATION_TITLES_URL = "/Titles.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", Title.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addFactoryCreate("eveapi/result/rowset/row/rowset", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				String name = attributes.getValue("name");
				if (name != null) {
					RoleBag roleBag = new RoleBag();
					roleBag.setName(name);
					return roleBag;
				}
				return null;
			}
		});
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", Role.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addRole");
		digester.addSetNext("eveapi/result/rowset/row/rowset", "addRoleBag");
		digester.addSetNext("eveapi/result/rowset/row", "addTitle");
		return digester;
	}

	public Response getTitles(ApiAuth auth) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		requestUrl += CORP_PATH;
		requestUrl += CORPORATION_TITLES_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=2";
		return getResponse(requestUrl, getDigester());
	}

	public static Parser getInstance() {
		return new Parser();
	}
}