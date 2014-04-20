package com.beimin.eveapi.eve.typename;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.StringUtils;

public class TypeNameParser extends AbstractListParser<TypeNameHandler, TypeNameResponse, EveTypeName> {
	public TypeNameParser() {
		super(TypeNameResponse.class, 2, ApiPath.EVE, ApiPage.TYPE_NAME, TypeNameHandler.class);
	}

	public TypeNameResponse getResponse(int... arguments) throws ApiException {
		return super.getResponse("ids", StringUtils.join(",", arguments));
	}
}