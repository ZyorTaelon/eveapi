package com.beimin.eveapi.character.marketorders;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.marketorders.AbstractMarketOrdersParser;

public class CharacterMarketOrdersParser extends AbstractMarketOrdersParser {
	public CharacterMarketOrdersParser() {
		super(ApiPath.CHARACTER);
	}
}