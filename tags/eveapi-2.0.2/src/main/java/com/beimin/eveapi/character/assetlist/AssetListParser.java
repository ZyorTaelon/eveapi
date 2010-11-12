package com.beimin.eveapi.character.assetlist;

import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;

public class AssetListParser extends AbstractAssetListParser {

	private AssetListParser() {
		super(Path.CHARACTER);
	}

	public static AssetListParser getInstance() {
		return new AssetListParser();
	}
}