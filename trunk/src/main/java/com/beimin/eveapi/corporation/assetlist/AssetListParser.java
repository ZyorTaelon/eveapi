package com.beimin.eveapi.corporation.assetlist;

import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;

public class AssetListParser extends AbstractAssetListParser {

	private AssetListParser() {
		super(Path.CORPORATION);
	}

	public static AssetListParser getInstance() {
		return new AssetListParser();
	}
}