package com.beimin.eveapi.assets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.assets.Asset;
import com.betterbe.eveapi.assets.Parser;
import com.betterbe.eveapi.assets.Response;

public class ParserTest {
	@Test
	public void testAssetsParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/AssetList.xml");
		Response response = parser.getAssets(input);
		assertNotNull("Should have returned a result.", response);
		assertEquals("Sun Feb 03 04:43:55 CET 2008", response.getCurrentTime().toString());
		assertEquals("Mon Feb 04 03:43:55 CET 2008", response.getCachedUntil().toString());
		Collection<Asset> assets = response.getAssets();
		assertNotNull("Should have returned assets.", assets);
		assertEquals("There should have been 4 assets.", 4, assets.size());
		boolean assetFound = false;
		boolean subAssetFound = false;
		for (Asset asset : assets) {
			int itemID = asset.getItemID();
			if (100173218 == itemID) {
				assetFound = true;
				Collection<Asset> subAssets = asset.getAssets();
				assertNotNull("Should have returned assets.", subAssets);
				assertEquals("There should have been 5 sub assets.", 5, subAssets.size());
				for (Asset subAsset : subAssets) {
					if (105204820 == subAsset.getItemID()) {
						subAssetFound = true;
						Collection<Asset> subSubAssets = subAsset.getAssets();
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