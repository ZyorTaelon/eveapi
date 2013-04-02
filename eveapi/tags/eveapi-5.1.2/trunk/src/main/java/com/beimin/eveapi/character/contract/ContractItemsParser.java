package com.beimin.eveapi.character.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.items.AbstractContractItemsParser;

public class ContractItemsParser extends AbstractContractItemsParser {
	protected ContractItemsParser() {
		super(ApiPath.CHARACTER);
	}

	public static ContractItemsParser getInstance() {
		return new ContractItemsParser();
	}
}