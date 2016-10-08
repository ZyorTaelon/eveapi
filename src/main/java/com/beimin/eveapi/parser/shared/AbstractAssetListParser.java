package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.shared.AssetListHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.AssetListResponse;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse> {
    protected AbstractAssetListParser(final ApiPath path) {
        super(AssetListResponse.class, 2, path, ApiPage.ASSET_LIST);
    }

    @Override
    protected AbstractContentHandler<AssetListResponse> getContentHandler() {
        return new AssetListHandler();
    }

    @Override
    public AssetListResponse getResponse(final ApiAuth auth) throws ApiException {
        return super.getResponse(auth);
    }

    public AssetListResponse getResponse(final ApiAuth auth, final boolean flat) throws ApiException {
        return super.getResponse(auth, "flat", flat ? "1" : "0");
    }
}
