package com.beimin.eveapi.character.assetlist;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.PilotAssetListParser;
import com.beimin.eveapi.parser.shared.AbstractAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class AssetListParserTest extends FullAuthParserTest {
	public AssetListParserTest() {
		super(ApiPath.CHARACTER, ApiPage.ASSET_LIST);
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getResponse() throws ApiException {
		AbstractAssetListParser parser = new PilotAssetListParser();
		AssetListResponse response = parser.getResponse(auth);
		assertNotNull("Should have returned a result.", response);
		assertDate(2008, 2, 3, 4, 43, 55, response.getCurrentTime());
		assertDate(2008, 2, 4, 3, 43, 55, response.getCachedUntil());
		Collection<Asset<Asset<?>>> assets = response.getAll();
		assertNotNull("Should have returned assets.", assets);
		assertEquals("There should have been 4 assets.", 4, assets.size());
		boolean assetFound = false;
		boolean subAssetFound = false;
		for (Asset asset : assets) {
			long itemID = asset.getItemID();
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
						assertEquals("There should have been 2 sub assets.", 2, subSubAssets.size());
					}
				}
			}
		}
		assertTrue("The asset with sub assets wasn't found", assetFound);
		assertTrue("The sub asset with a sub sub asset wasn't found", subAssetFound);

		testSingleton(assets);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void testSingleton(Collection<Asset<Asset<?>>> assets){
		for (Asset asset : assets) {
			testSingleton(asset);
			testSingleton(asset.getAssets());
		}
	}

	private void testSingleton(Asset<Asset<?>> asset){
		if (asset.getSingleton() && asset.getRawQuantity() != -1 && asset.getRawQuantity() != -2){
			fail("When Singleton is true: RawQuantity should be -1 or -2 was: "+asset.getRawQuantity()+" itemID: "+asset.getItemID());
		}
		if (!asset.getSingleton() && asset.getRawQuantity() != 0 && asset.getRawQuantity() != -2){
			fail("When Singleton is false: RawQuantity should be 0 or -2 was: "+asset.getRawQuantity()+" itemID: "+asset.getItemID());
		}

	}
}