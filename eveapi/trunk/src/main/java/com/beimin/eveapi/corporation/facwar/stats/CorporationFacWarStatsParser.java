package com.beimin.eveapi.corporation.facwar.stats;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.facwar.stats.AbstractFacWarStatsParser;

public class CorporationFacWarStatsParser extends AbstractFacWarStatsParser {
	public CorporationFacWarStatsParser() {
		super(ApiPath.CORPORATION);
	}
}