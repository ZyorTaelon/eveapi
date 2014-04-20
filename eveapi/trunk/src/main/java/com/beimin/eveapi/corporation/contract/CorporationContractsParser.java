package com.beimin.eveapi.corporation.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.AbstractContractsParser;

public class CorporationContractsParser extends AbstractContractsParser {
	public CorporationContractsParser() {
		super(ApiPath.CORPORATION);
	}
}