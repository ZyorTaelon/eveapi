package com.beimin.eveapi.character.facwar.stats;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.facwar.stats.AbstractFacWarStatsParser;

public class CharacterFacWarStatsParser extends AbstractFacWarStatsParser {
	public CharacterFacWarStatsParser() {
		super(ApiPath.CHARACTER);
	}
}