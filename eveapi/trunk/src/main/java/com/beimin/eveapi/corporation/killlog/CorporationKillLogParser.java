package com.beimin.eveapi.corporation.killlog;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;

public class CorporationKillLogParser extends AbstractKillLogParser {
	public CorporationKillLogParser() {
		super(ApiPath.CORPORATION);
	}
}