package com.beimin.eveapi.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.junit.Test;
import org.xml.sax.SAXException;


public class ParserTest {
	@Test
	public void testAssetsParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/AssetList.xml");
		Response response = parser.getResponse(input);
		assertNotNull("Should have returned a result.", response);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2008, 1, 3, 4, 43, 55);
		Date currentTime = calendar.getTime();
		assertEquals(currentTime.toString(), response.getCurrentTime().toString());
		calendar.set(2008, 1, 4, 3, 43, 55);
		Date cachedUntil = calendar.getTime();
		assertEquals(cachedUntil.toString(), response.getCachedUntil().toString());
		Collection<ApiAsset> assets = response.getAssets();
		assertNotNull("Should have returned assets.", assets);
		assertEquals("There should have been 4 assets.", 4, assets.size());
		boolean assetFound = false;
		boolean subAssetFound = false;
		for (ApiAsset asset : assets) {
			int itemID = asset.getItemID();
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