package com.beimin.eveapi.character.killlog;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;

public class CharacterKillLogParser extends AbstractKillLogParser {
	public CharacterKillLogParser() {
		super(ApiPath.CHARACTER);
	}
}