package com.beimin.eveapi.corporation.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.AbstractContractsParser;

public class ContractsParser extends AbstractContractsParser {
	protected ContractsParser() {
		super(3, ApiPath.CORPORATION);
	}
	
	public static ContractsParser getInstance() {
		return new ContractsParser();
	}
}