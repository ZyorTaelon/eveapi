package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractBlueprintsParser;
import com.beimin.eveapi.response.shared.BlueprintsResponse;

public class BlueprintsParser extends AbstractBlueprintsParser {
	public BlueprintsParser() {
		super(ApiPath.CORPORATION);
	}

	@Override
	public BlueprintsResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}