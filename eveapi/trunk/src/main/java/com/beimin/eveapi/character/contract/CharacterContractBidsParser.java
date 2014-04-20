package com.beimin.eveapi.character.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.bids.AbstractContractBidsParser;

public class CharacterContractBidsParser extends AbstractContractBidsParser {
	public CharacterContractBidsParser() {
		super(ApiPath.CHARACTER);
	}
}