package com.beimin.eveapi.character.assetlist;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;

public class CharacterAssetListParser extends AbstractAssetListParser {
	public CharacterAssetListParser() {
		super(ApiPath.CHARACTER);
	}
}