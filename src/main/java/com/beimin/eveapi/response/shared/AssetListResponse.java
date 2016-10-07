package com.beimin.eveapi.response.shared;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.response.ApiResponse;

public class AssetListResponse extends ApiResponse {
    private final List<Asset> assets = new ArrayList<Asset>();

    public void add(final Asset asset) {
        assets.add(asset);
    }

    public List<Asset> getAll() {
        return assets;
    }
}