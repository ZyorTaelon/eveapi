package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.ContractsHandler;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.ContractsResponse;

public abstract class AbstractContractsParser extends AbstractListParser<ContractsHandler, ContractsResponse, Contract> {
	protected AbstractContractsParser(ApiPath path) {
		super(ContractsResponse.class, 2, path, ApiPage.CONTRACTS, ContractsHandler.class);
	}
	
	@Override
	public ContractsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}