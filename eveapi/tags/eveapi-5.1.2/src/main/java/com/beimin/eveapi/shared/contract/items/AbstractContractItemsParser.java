package com.beimin.eveapi.shared.contract.items;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public abstract class AbstractContractItemsParser extends AbstractListParser<ContractItemsHandler, ContractItemsResponse, EveContractItem> {
	protected AbstractContractItemsParser(ApiPath path) {
		super(ContractItemsResponse.class, 2, path, ApiPage.CONTRACT_ITEMS, ContractItemsHandler.class);
	}

	/**
	 * Use this when your API Key is connected to a single character
	 */
	public ContractItemsResponse getResponse(ApiAuthorization auth, long contractID) throws ApiException {
		return super.getResponse(auth, "contractID", Long.toString(contractID));
	}

	/**
	 * Use this when your API Key is connected to multiple characters
	 */
	public ContractItemsResponse getResponse(ApiAuthorization auth, long characterID, long contractID) throws ApiException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("characterID", Long.toString(characterID));
		extraParams.put("contractID", Long.toString(contractID));
		return super.getResponse(auth, extraParams);
	}
}