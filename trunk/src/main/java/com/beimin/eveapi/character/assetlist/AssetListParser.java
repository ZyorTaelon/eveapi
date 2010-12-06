package com.beimin.eveapi.character.assetlist;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;

public class AssetListParser extends AbstractAssetListParser {
	private AssetListParser() {
		super(ApiPath.CHARACTER);
	}

	public static AssetListParser getInstance() {
		return new AssetListParser();
	}
}