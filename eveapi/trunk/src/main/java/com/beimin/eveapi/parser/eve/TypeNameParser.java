package com.beimin.eveapi.parser.eve;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.eve.TypeNameHandler;
import com.beimin.eveapi.model.eve.EveTypeName;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.eve.TypeNameResponse;
import com.beimin.eveapi.utils.StringUtils;

public class TypeNameParser extends AbstractListParser<TypeNameHandler, TypeNameResponse, EveTypeName> {
	public TypeNameParser() {
		super(TypeNameResponse.class, 2, ApiPath.EVE, ApiPage.TYPE_NAME, TypeNameHandler.class);
	}

	public TypeNameResponse getResponse(int... arguments) throws ApiException {
		return super.getResponse("ids", StringUtils.join(",", arguments));
	}
}