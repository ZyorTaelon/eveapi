package com.beimin.eveapi.character.killlog;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;

public class KillLogParser extends AbstractKillLogParser {
	private KillLogParser() {
		super(ApiPath.CHARACTER);
	}

	public static KillLogParser getInstance() {
		return new KillLogParser();
	}
}