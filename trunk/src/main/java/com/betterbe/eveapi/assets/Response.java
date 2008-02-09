package com.betterbe.eveapi.assets;

import java.util.Collection;
import java.util.HashSet;

import com.betterbe.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<Asset> assets = new HashSet<Asset>();

	public void addAsset(Asset asset) {
		assets.add(asset);
	}

	public Collection<Asset> getAssets() {
		return assets;
	}
}
