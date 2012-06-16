package com.beimin.eveapi.eve.character;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.StringUtils;

public class CharacterLookupParser extends AbstractListParser<CharacterLookupHandler, CharacterLookupResponse, ApiCharacterLookup> {
	private final String paramName;

	public CharacterLookupParser(ApiPage page, String paramName) {
		super(CharacterLookupResponse.class, 2, ApiPath.EVE, page, CharacterLookupHandler.class);
		this.paramName = paramName;
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