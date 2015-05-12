package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractAssetListParser;

public class PilotAssetListParser extends AbstractAssetListParser {
	public PilotAssetListParser() {
		super(ApiPath.CHARACTER);
	}
}