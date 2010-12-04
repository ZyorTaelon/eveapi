package com.beimin.eveapi.eve.character;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.StringUtils;

public class CharacterLookupParser extends AbstractApiParser<CharacterLookupResponse> {
	private final String paramName;

	public CharacterLookupParser(ApiPage page, String paramName) {
		super(CharacterLookupResponse.class, 2, ApiPath.EVE, page);
		this.paramName = paramName;
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
		return new CharacterLookupParser(ApiPage.CHARACTER_ID, "names");
	}

	public static CharacterLookupParser getId2NameInstance() {
		return new CharacterLookupParser(ApiPage.CHARACTER_NAME, "ids");
	}

	public CharacterLookupResponse getResponse(String... arguments) throws IOException, SAXException {
		return super.getResponse(paramName, StringUtils.join(",", arguments).replaceAll(" ", "%20"));
	}

	public CharacterLookupResponse getResponse(long... arguments) throws IOException, SAXException {
		return super.getResponse(paramName, StringUtils.join(",", arguments));
	}
}