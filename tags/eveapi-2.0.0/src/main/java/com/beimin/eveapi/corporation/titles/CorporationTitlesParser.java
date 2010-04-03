package com.beimin.eveapi.corporation.titles;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class CorporationTitlesParser extends AbstractApiParser<CorporationTitlesResponse> {
	protected static final String CORPORATION_TITLES_URL = Path.CORP.getPath() + "/Titles.xml.aspx";

	public CorporationTitlesParser() {
		super(CorporationTitlesResponse.class, 2, CORPORATION_TITLES_URL);
	}

	public CorporationTitlesResponse getTitles(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiTitle.class);
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
		digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiRole.class);
		digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addRole");
		digester.addSetNext("eveapi/result/rowset/row/rowset", "addRoleBag");
		digester.addSetNext("eveapi/result/rowset/row", "addTitle");
		return digester;
	}

	public static CorporationTitlesParser getInstance() {
		return new CorporationTitlesParser();
	}
}