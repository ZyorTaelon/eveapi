package com.beimin.eveapi.character.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.items.AbstractContractItemsParser;

public class CharacterContractItemsParser extends AbstractContractItemsParser {
	public CharacterContractItemsParser() {
		super(ApiPath.CHARACTER);
	}
}