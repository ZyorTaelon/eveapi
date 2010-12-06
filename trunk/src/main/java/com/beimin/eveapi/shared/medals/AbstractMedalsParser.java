package com.beimin.eveapi.shared.medals;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public abstract class AbstractMedalsParser<M extends Medal> extends AbstractApiParser<MedalsResponse> {
	private final Class<M> medalClass;

	protected AbstractMedalsParser(ApiPath path, Class<M> medalClass) {
		super(MedalsResponse.class, 2, path, ApiPage.MEDALS);
		this.medalClass = medalClass;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", medalClass);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMedal");
		return digester;
	}

	@Override
	public MedalsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}