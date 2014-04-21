package com.beimin.eveapi.response.shared;

import java.util.LinkedHashSet;
import java.util.Set;

import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.response.ApiResponse;

public class AssetListResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Set<Asset<Asset<?>>> assets = new LinkedHashSet<Asset<Asset<?>>>();

	public void add(Asset<Asset<?>> asset) {
		assets.add(asset);
	}

	public Set<Asset<Asset<?>>> getAll() {
		return assets;
	}
}