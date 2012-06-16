package com.beimin.eveapi.asset;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiAsset> assets = new HashSet<ApiAsset>();

	public void addAsset(ApiAsset asset) {
		assets.add(asset);
	}

	public Collection<ApiAsset> getAssets() {
		return assets;
	}
}
