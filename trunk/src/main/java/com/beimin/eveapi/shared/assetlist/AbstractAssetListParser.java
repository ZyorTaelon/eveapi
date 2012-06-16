package com.beimin.eveapi.shared.assetlist;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse> {
	protected AbstractAssetListParser(ApiPath path) {
		super(AssetListResponse.class, 2, path, ApiPage.ASSET_LIST);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new AssetListHandler();
	}

//	@Override
//	protected Digester getDigester() {
//		Digester digester = super.getDigester();
//		digester.addObjectCreate("*/rowset/row", EveAsset.class);
//		digester.addSetProperties("*/rowset/row");
//		digester.addSetNext("*/rowset/row", "add");
//		return digester;
//	}

	@Override
	public AssetListResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}