package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.shared.AssetListHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.AssetListResponse;

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