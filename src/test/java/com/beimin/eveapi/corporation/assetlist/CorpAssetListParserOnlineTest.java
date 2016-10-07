package com.beimin.eveapi.corporation.assetlist;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.AssetListParser;
import com.beimin.eveapi.parser.shared.AbstractAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class CorpAssetListParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		AbstractAssetListParser parser = new AssetListParser();
		AssetListResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

	@Test
	public void getResponseFlat() throws Exception {
		AbstractAssetListParser parser = new AssetListParser();
		AssetListResponse response = parser.getResponse(getCorp(), true);
		testResponse(response);
	}

}