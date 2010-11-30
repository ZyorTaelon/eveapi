package com.beimin.eveapi.eve.character;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class CharacterLookupParser extends AbstractApiParser<CharacterLookupResponse> {
	protected static final String CHARACTER_NAME_URL = "/CharacterName";
	protected static final String CHARACTER_ID_URL = "/CharacterID";
	private final String paramName;

	public CharacterLookupParser(String url, String paramName) {
		super(CharacterLookupResponse.class, 2, Path.EVE, url);
		this.paramName = paramName;
	}

	public CharacterLookupResponse getCharacterList(String... arguments) throws IOException, SAXException {
		String paramValue = "";
		for (int i = 0; i < arguments.length; i++) {
			paramValue += arguments[i];
			if (i < arguments.length - 1)
				paramValue += ",";
		}
		return getResponse(paramName, paramValue.replaceAll(" ", "%20"));
	}

	public CharacterLookupResponse getCharacterList(long... arguments) throws IOException, SAXException {
		String paramValue = "";
		for (int i = 0; i < arguments.length; i++) {
			paramValue += arguments[i];
			if (i < arguments.length - 1)
				paramValue += ",";
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

	public static CharacterLookupParser getName2IdInstance() {
		return new CharacterLookupParser(CHARACTER_ID_URL, "names");
	}

	public static CharacterLookupParser getId2NameInstance() {
		return new CharacterLookupParser(CHARACTER_NAME_URL, "ids");
	}
}
