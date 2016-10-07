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

/**
 * There are two methods, one for API keys with only a single character and one for multi-character API keys.
 */
public abstract class AbstractContractItemsParser extends AbstractListParser<ContractItemsHandler, ContractItemsResponse, ContractItem> {
    protected AbstractContractItemsParser(final ApiPath path) {
        super(ContractItemsResponse.class, 2, path, ApiPage.CONTRACT_ITEMS, ContractItemsHandler.class);
    }

    public ContractItemsResponse getResponse(final ApiAuthorization auth, final long contractID) throws ApiException {
        return super.getResponse(auth, "contractID", Long.toString(contractID));
    }

    public ContractItemsResponse getResponse(final ApiAuthorization auth, final long characterID, final long contractID) throws ApiException {
        final Map<String, String> extraParams = new HashMap<String, String>();
        extraParams.put("characterID", Long.toString(characterID));
        extraParams.put("contractID", Long.toString(contractID));
        return super.getResponse(auth, extraParams);
    }
}
