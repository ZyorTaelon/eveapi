package com.beimin.eveapi.corporation.facwar.stats;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.facwar.stats.AbstractFacWarStatsParser;

public class FacWarStatsParser extends AbstractFacWarStatsParser {
	private FacWarStatsParser() {
		super(ApiPath.CORPORATION);
	}

	public static FacWarStatsParser getInstance() {
		return new FacWarStatsParser();
	}
}