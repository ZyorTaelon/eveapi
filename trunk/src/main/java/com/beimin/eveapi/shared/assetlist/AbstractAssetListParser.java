package com.beimin.eveapi.shared.assetlist;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse> {
	protected AbstractAssetListParser(ApiPath path) {
		super(AssetListResponse.class, 2, path, ApiPage.ASSET_LIST);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("*/rowset/row", ApiAsset.class);
		digester.addSetProperties("*/rowset/row");
		digester.addSetNext("*/rowset/row", "addAsset");
		return digester;
	}

	@Override
	public AssetListResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}