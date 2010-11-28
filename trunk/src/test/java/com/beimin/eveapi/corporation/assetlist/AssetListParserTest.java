package com.beimin.eveapi.corporation.assetlist;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;
import com.beimin.eveapi.shared.assetlist.ApiAsset;
import com.beimin.eveapi.shared.assetlist.AssetListResponse;

public class AssetListParserTest {
	@Test
	public void assetListParser() throws IOException, SAXException {
		AbstractAssetListParser parser = AssetListParser.getInstance();
		InputStream input = AssetListParserTest.class.getResourceAsStream("/corporation/AssetList.xml");
		AssetListResponse response = parser.getResponse(input);
		assertNotNull("Should have returned a result.", response);
		assertDate(2008, 2, 3, 4, 43, 55, response.getCurrentTime());
		assertDate(2008, 2, 4, 3, 43, 55, response.getCachedUntil());
		Collection<ApiAsset> assets = response.getAssets();
		assertNotNull("Should have returned assets.", assets);
		assertEquals("There should have been 4 assets.", 4, assets.size());
		boolean assetFound = false;
		boolean subAssetFound = false;
		for (ApiAsset asset : assets) {
			long itemID = asset.getItemID();
			if (100173218 == itemID) {
				assetFound = true;
				Collection<ApiAsset> subAssets = asset.getAssets();
				assertNotNull("Should have returned assets.", subAssets);
				assertEquals("There should have been 5 sub assets.", 5, subAssets.size());
				for (ApiAsset subAsset : subAssets) {
					if (105204820 == subAsset.getItemID()) {
						subAssetFound = true;
						Collection<ApiAsset> subSubAssets = subAsset.getAssets();
						assertNotNull("Should have returned assets.", subSubAssets);
						assertEquals("There should have been 1 sub assets.", 1, subSubAssets.size());
					}
				}
			}
		}
		assertTrue("The asset with sub assets wasn't found", assetFound);
		assertTrue("The sub asset with a sub sub asset wasn't found", subAssetFound);
	}
}