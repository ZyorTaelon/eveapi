package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractKillLogParser;

public class KillLogParser extends AbstractKillLogParser {
	public KillLogParser() {
		super(ApiPath.CORPORATION);
	}
}