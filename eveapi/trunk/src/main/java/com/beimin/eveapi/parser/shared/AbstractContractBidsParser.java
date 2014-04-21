package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.ContractIBidsHandler;
import com.beimin.eveapi.model.shared.ContractBid;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.ContractBidsResponse;

public abstract class AbstractContractBidsParser extends AbstractListParser<ContractIBidsHandler, ContractBidsResponse, ContractBid> {
	protected AbstractContractBidsParser(ApiPath path) {
		super(ContractBidsResponse.class, 2, path, ApiPage.CONTRACT_BIDS, ContractIBidsHandler.class);
	}

	@Override
	public ContractBidsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}