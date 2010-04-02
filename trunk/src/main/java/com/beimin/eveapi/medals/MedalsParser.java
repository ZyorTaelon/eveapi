package com.beimin.eveapi.medals;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MedalsParser extends AbstractApiParser<MedalsResponse> {
	protected static final String MEDALS_URL = "/Medals.xml.aspx";

	public MedalsParser() {
		super(MedalsResponse.class, 2, MEDALS_URL);
	}

	public MedalsResponse getKillList(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		if (corporation)
			return getResponse(auth, Path.CORP);
		return getResponse(auth, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addFactoryCreate("eveapi/result/rowset/row", new AbstractObjectCreationFactory() {
			@Override
			public Object createObject(Attributes attributes) throws Exception {
				if (attributes.getValue("status") != null)
					return new CharacterMedal();
				return new CorpMedal();
			}
		});
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMedal");
		return digester;
	}

	public static MedalsParser getInstance() {
		return new MedalsParser();
	}
}