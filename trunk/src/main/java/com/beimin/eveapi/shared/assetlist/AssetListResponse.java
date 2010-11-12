package com.beimin.eveapi.shared.assetlist;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class AssetListResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiAsset> assets = new HashSet<ApiAsset>();

	public void addAsset(ApiAsset asset) {
		assets.add(asset);
	}

	public Collection<ApiAsset> getAssets() {
		return assets;
	}
}
