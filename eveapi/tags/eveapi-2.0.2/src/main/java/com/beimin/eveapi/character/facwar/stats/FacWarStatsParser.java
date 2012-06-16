package com.beimin.eveapi.character.facwar.stats;

import com.beimin.eveapi.shared.factwar.stats.AbstractFactWarStatsParser;

public class FacWarStatsParser extends AbstractFactWarStatsParser {

	private FacWarStatsParser() {
		super(Path.CHARACTER);
	}

	public static FacWarStatsParser getInstance() {
		return new FacWarStatsParser();
	}
}