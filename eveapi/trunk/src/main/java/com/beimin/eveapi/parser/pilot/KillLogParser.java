package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractKillLogParser;

public class KillLogParser extends AbstractKillLogParser {
	public KillLogParser() {
		super(ApiPath.CHARACTER);
	}
}