package com.beimin.eveapi.asset;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<Asset> assets = new HashSet<Asset>();

	public void addAsset(Asset asset) {
		assets.add(asset);
	}

	public Collection<Asset> getAssets() {
		return assets;
	}
}
