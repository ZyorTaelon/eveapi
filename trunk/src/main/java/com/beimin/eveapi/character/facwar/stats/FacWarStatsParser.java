package com.beimin.eveapi.character.facwar.stats;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.factwar.stats.AbstractFactWarStatsParser;

public class FacWarStatsParser extends AbstractFactWarStatsParser {
	private FacWarStatsParser() {
		super(ApiPath.CHARACTER);
	}

	public static FacWarStatsParser getInstance() {
		return new FacWarStatsParser();
	}
}