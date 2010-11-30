package com.beimin.eveapi.corporation.sheet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class CorpSheetParser extends AbstractApiParser<CorpSheetResponse> {
	protected static final String CORPORATION_SHEET_URL = "/CorporationSheet";

	public CorpSheetParser() {
		super(CorpSheetResponse.class, 2, Path.CORPORATION, CORPORATION_SHEET_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/corporationID");
		digester.addBeanPropertySetter("eveapi/result/corporationName");
		digester.addBeanPropertySetter("eveapi/result/ticker");
		digester.addBeanPropertySetter("eveapi/result/ceoID");
		digester.addBeanPropertySetter("eveapi/result/ceoName");
		digester.addBeanPropertySetter("eveapi/result/stationID");
		digester.addBeanPropertySetter("eveapi/result/stationName");
		digester.addBeanPropertySetter("eveapi/result/description");
		digester.addBeanPropertySetter("eveapi/result/url");
		digester.addBeanPropertySetter("eveapi/result/allianceID");
		digester.addBeanPropertySetter("eveapi/result/allianceName");
		digester.addBeanPropertySetter("eveapi/result/taxRate");
		digester.addBeanPropertySetter("eveapi/result/memberCount");
		digester.addBeanPropertySetter("eveapi/result/memberLimit");
		digester.addBeanPropertySetter("eveapi/result/shares");
		digester.addObjectCreate("eveapi/result/logo", ApiCorpLogo.class);
		digester.addBeanPropertySetter("eveapi/result/logo/graphicsID");
		digester.addBeanPropertySetter("eveapi/result/logo/shape1");
		digester.addBeanPropertySetter("eveapi/result/logo/shape2");
		digester.addBeanPropertySetter("eveapi/result/logo/shape3");
		digester.addBeanPropertySetter("eveapi/result/logo/color1");
		digester.addBeanPropertySetter("eveapi/result/logo/color2");
		digester.addBeanPropertySetter("eveapi/result/logo/color3");
		digester.addSetNext("eveapi/result/logo", "setLogo");
		digester.addFactoryCreate("eveapi/result/rowset", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				String name = attributes.getValue("name");
				if (name != null) {
					DivisionList divisionList = new DivisionList();
					divisionList.setName(name);
					return divisionList;
				}
				return null;
			}
		});
		digester.addObjectCreate("eveapi/result/rowset/row", Division.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addDivision");
		digester.addSetNext("eveapi/result/rowset", "addDivisionList");
		return digester;
	}

	public CorpSheetResponse getCorporationSheet(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	public CorpSheetResponse getCorporationSheet(long corporationID) throws IOException, SAXException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("corporationID", Long.toString(corporationID));
		return getResponse(params);
	}

	public static CorpSheetParser getInstance() {
		return new CorpSheetParser();
	}
}