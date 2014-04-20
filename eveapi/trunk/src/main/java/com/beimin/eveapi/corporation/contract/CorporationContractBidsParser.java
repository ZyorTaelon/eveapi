package com.beimin.eveapi.corporation.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.bids.AbstractContractBidsParser;

public class CorporationContractBidsParser extends AbstractContractBidsParser {
	public CorporationContractBidsParser() {
		super(ApiPath.CORPORATION);
	}
}