package com.beimin.eveapi.character.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.bids.AbstractContractBidsParser;

public class ContractBidsParser extends AbstractContractBidsParser {
	protected ContractBidsParser() {
		super(ApiPath.CHARACTER);
	}
	
	public static ContractBidsParser getInstance() {
		return new ContractBidsParser();
	}
}