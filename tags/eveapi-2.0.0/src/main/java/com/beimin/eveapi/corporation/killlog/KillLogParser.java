package com.beimin.eveapi.corporation.killlog;

import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;

public class KillLogParser extends AbstractKillLogParser {

	private KillLogParser() {
		super(Path.CORP);
	}

	public static KillLogParser getInstance() {
		return new KillLogParser();
	}
}