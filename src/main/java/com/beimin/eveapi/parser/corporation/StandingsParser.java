package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {
	public StandingsParser() {
		super(ApiPath.CORPORATION);
	}
}