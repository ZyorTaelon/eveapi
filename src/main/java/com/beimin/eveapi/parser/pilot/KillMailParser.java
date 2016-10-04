package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractKillMailParser;

public class KillMailParser extends AbstractKillMailParser {
	public KillMailParser() {
		super(ApiPath.CHARACTER);
	}
}