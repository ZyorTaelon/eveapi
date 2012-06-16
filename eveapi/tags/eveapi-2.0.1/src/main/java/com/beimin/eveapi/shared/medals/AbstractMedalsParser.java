package com.beimin.eveapi.shared.medals;

import java.io.IOException;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractMedalsParser<M extends Medal> extends AbstractApiParser<MedalsResponse> {
	protected static final String MEDALS_URL = "/Medals.xml.aspx";
	private final Path path;
	private final Class<M> medalClass;

	protected AbstractMedalsParser(Path path, Class<M> medalClass) {
		super(MedalsResponse.class, 2, MEDALS_URL);
		this.path = path;
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

	public MedalsResponse getMedalsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}

	public List<Medal> getMedals(ApiAuth auth) throws IOException, SAXException {
		return getMedalsResponse(auth).getMedals();
	}
}