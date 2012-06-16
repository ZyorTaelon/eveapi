package com.beimin.eveapi.shared.assetlist;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.core.ApiResponse;

public class AssetListResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiAsset<ApiAsset<?>>> assets = new HashSet<ApiAsset<ApiAsset<?>>>();

	public void addAsset(ApiAsset<ApiAsset<?>> asset) {
		assets.add(asset);
	}

	public Collection<ApiAsset<ApiAsset<?>>> getAssets() {
		return assets;
	}
}
