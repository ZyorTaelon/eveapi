package com.beimin.eveapi.corporation.factwar.stats;

import com.beimin.eveapi.shared.factwar.stats.AbstractFactWarStatsParser;

public class FacWarStatsParser extends AbstractFactWarStatsParser {

	private FacWarStatsParser() {
		super(Path.CORPORATION);
	}

	public static FacWarStatsParser getInstance() {
		return new FacWarStatsParser();
	}
}