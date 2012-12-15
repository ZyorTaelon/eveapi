package com.beimin.eveapi.character.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.AbstractContractsParser;

public class ContractsParser extends AbstractContractsParser {
	protected ContractsParser() {
		super(2, ApiPath.CHARACTER);
	}
	
	public static ContractsParser getInstance() {
		return new ContractsParser();
	}
}