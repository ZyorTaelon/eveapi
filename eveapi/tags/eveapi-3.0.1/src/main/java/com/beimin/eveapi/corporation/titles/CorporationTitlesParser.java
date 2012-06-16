package com.beimin.eveapi.corporation.titles;


import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CorporationTitlesParser extends AbstractApiParser<CorporationTitlesResponse> {
	public CorporationTitlesParser() {
		super(CorporationTitlesResponse.class, 2, ApiPath.CORPORATION, ApiPage.TITLES);
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

	@Override
	public CorporationTitlesResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}