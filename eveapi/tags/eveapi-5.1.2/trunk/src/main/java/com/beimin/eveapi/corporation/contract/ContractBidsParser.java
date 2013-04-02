package com.beimin.eveapi.corporation.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.bids.AbstractContractBidsParser;

public class ContractBidsParser extends AbstractContractBidsParser {
	protected ContractBidsParser() {
		super(ApiPath.CORPORATION);
	}
	
	public static ContractBidsParser getInstance() {
		return new ContractBidsParser();
	}
}