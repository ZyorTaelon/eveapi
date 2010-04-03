package com.beimin.eveapi.character.killlog;

import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;

public class KillLogParser extends AbstractKillLogParser {

	private KillLogParser() {
		super(Path.CHARACTER);
	}

	public static KillLogParser getInstance() {
		return new KillLogParser();
	}
}