package com.beimin.eveapi.corporation.killlog;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;

public class KillLogParser extends AbstractKillLogParser {
	private KillLogParser() {
		super(ApiPath.CORPORATION);
	}

	public static KillLogParser getInstance() {
		return new KillLogParser();
	}
}