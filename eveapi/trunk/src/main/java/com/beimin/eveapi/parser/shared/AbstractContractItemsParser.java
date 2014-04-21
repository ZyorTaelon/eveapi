package com.beimin.eveapi.parser.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.ContractItemsHandler;
import com.beimin.eveapi.model.shared.ContractItem;
import com.beimin.eveapi.parser.ApiAuthorization;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.ContractItemsResponse;

public abstract class AbstractContractItemsParser extends AbstractListParser<ContractItemsHandler, ContractItemsResponse, ContractItem> {
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