package com.beimin.eveapi.corporation.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.items.AbstractContractItemsParser;

public class CorporationContractItemsParser extends AbstractContractItemsParser {
	public CorporationContractItemsParser() {
		super(ApiPath.CORPORATION);
	}
}