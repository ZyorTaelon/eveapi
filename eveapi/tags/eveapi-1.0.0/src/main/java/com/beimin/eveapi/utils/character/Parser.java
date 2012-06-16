package com.beimin.eveapi.utils.character;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String CHARACTER_NAME_URL = "/eve/CharacterName.xml.aspx";
	protected static final String CHARACTER_ID_URL = "/eve/CharacterID.xml.aspx";
	private final String paramName;

	public Parser(String url, String paramName) {
		super(Response.class, 2, url);
		this.paramName = paramName;
	}

	public Response getCharacterList(String... arguments) throws IOException, SAXException {
		String paramValue = "";
		for (int i = 0; i < arguments.length; i++) {
			paramValue+=arguments[i];
			if(i < arguments.length-1)
				paramValue+=",";
		}
		return getResponse(paramName, paramValue.replaceAll(" ", "%20"));
	}

	public Response getCharacterList(long... arguments) throws IOException, SAXException {
		String paramValue = "";
		for (int i = 0; i < arguments.length; i++) {
			paramValue+=arguments[i];
			if(i < arguments.length-1)
				paramValue+=",";
		}
		return getResponse(paramName, paramValue);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiCharacterLookup.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addCharacterLookup");
		return digester;
	}

	public static Parser getName2IdInstance() {
		return new Parser(CHARACTER_ID_URL, "names");
	}

	public static Parser getId2NameInstance() {
		return new Parser(CHARACTER_NAME_URL, "ids");
	}
}
