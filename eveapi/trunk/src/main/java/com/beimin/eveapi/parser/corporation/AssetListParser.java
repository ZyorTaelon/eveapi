package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractAssetListParser;

public class AssetListParser extends AbstractAssetListParser {
	public AssetListParser() {
		super(ApiPath.CORPORATION);
	}
}