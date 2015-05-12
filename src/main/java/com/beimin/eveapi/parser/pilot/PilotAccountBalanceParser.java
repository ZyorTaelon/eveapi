package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractAccountBalanceParser;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class PilotAccountBalanceParser extends AbstractAccountBalanceParser {
	public PilotAccountBalanceParser() {
		super(ApiPath.CHARACTER);
	}

	@Override
	public AccountBalanceResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}