package com.beimin.eveapi.corporation.standings;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.standings.AbstractStandingsParser;

public class CorporationStandingsParser extends AbstractStandingsParser {
	public CorporationStandingsParser() {
		super(ApiPath.CORPORATION);
	}
}