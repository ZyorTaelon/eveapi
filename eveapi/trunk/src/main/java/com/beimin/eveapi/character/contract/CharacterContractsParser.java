package com.beimin.eveapi.character.contract;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contract.AbstractContractsParser;

public class CharacterContractsParser extends AbstractContractsParser {
	public CharacterContractsParser() {
		super(ApiPath.CHARACTER);
	}
}