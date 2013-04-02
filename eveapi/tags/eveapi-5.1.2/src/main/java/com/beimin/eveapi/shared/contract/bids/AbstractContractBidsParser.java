package com.beimin.eveapi.shared.contract.bids;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public abstract class AbstractContractBidsParser extends AbstractListParser<ContractIBidsHandler, ContractBidsResponse, EveContractBid> {
	protected AbstractContractBidsParser(ApiPath path) {
		super(ContractBidsResponse.class, 2, path, ApiPage.CONTRACT_BIDS, ContractIBidsHandler.class);
	}

	@Override
	public ContractBidsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}