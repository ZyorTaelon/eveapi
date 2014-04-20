package com.beimin.eveapi.character.accountbalance;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;
import com.beimin.eveapi.shared.accountbalance.AccountBalanceResponse;

public class CharacterAccountBalanceParser extends AbstractAccountBalanceParser {
	public CharacterAccountBalanceParser() {
		super(ApiPath.CHARACTER);
	}

	@Override
	public AccountBalanceResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}