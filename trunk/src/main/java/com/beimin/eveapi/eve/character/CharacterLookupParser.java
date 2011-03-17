package com.beimin.eveapi.eve.character;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
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

	public CharacterLookupResponse getResponse(String... arguments) throws ApiException {
		return super.getResponse(paramName, StringUtils.join(",", arguments));
	}

	public CharacterLookupResponse getResponse(long... arguments) throws ApiException {
		return super.getResponse(paramName, StringUtils.join(",", arguments));
	}
}