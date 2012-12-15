package com.beimin.eveapi.shared.contract;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public abstract class AbstractContractsParser extends AbstractListParser<ContractsHandler, ContractsResponse, EveContract> {
	protected AbstractContractsParser(int version, ApiPath path) {
		super(ContractsResponse.class, version, path, ApiPage.CONTRACTS, ContractsHandler.class);
	}
	
	@Override
	public ContractsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}