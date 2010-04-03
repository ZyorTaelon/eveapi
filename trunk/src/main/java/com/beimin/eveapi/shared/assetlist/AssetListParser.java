package com.beimin.eveapi.shared.assetlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class AssetListParser extends AbstractApiParser<AssetListResponse> {
	protected static final String ASSETLIST_URL = "/AssetList.xml.aspx";

	public AssetListParser() {
		super(AssetListResponse.class, 2, ASSETLIST_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("*/rowset/row", ApiAsset.class);
		digester.addSetProperties("*/rowset/row");
		digester.addSetNext("*/rowset/row", "addAsset");
		return digester;
	}

	public AssetListResponse getAssets(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		if (corporation)
			return getResponse(auth, Path.CORP);
		return getResponse(auth, Path.CHARACTER);
	}

	public static AssetListParser getInstance() {
		return new AssetListParser();
	}
}