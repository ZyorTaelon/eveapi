package com.beimin.eveapi.corporation.assetlist;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;

public class CorporationAssetListParser extends AbstractAssetListParser {
	public CorporationAssetListParser() {
		super(ApiPath.CORPORATION);
	}
}