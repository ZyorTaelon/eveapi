package com.beimin.eveapi.corporation.assetlist;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.CorpAssetListParser;
import com.beimin.eveapi.response.shared.AssetListResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CorpAssetListParserTest extends FullAuthParserTest {
    public CorpAssetListParserTest() {
        super(ApiPath.CORPORATION, ApiPage.ASSET_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final CorpAssetListParser parser = new CorpAssetListParser();
        final AssetListResponse response = parser.getResponse(auth);
        assertNotNull("Should have returned a result.", response);
        assertDate(2008, 2, 3, 4, 43, 55, response.getCurrentTime());
        assertDate(2008, 2, 4, 3, 43, 55, response.getCachedUntil());
        final List<Asset> assets = response.getAll();
        assertNotNull("Should have returned assets.", assets);
        assertEquals("There should have been 4 assets.", 4, assets.size());
        boolean assetFound = false;
        boolean subAssetFound = false;
        for (final Asset asset : assets) {
            final long itemID = asset.getItemID();
            if (100173218 == itemID) {
                assetFound = true;
                final Collection<Asset> subAssets = asset.getAssets();
                assertNotNull("Should have returned assets.", subAssets);
                assertEquals("There should have been 5 sub assets.", 5, subAssets.size());
                for (final Asset subAsset : subAssets) {
                    if (105204820 == subAsset.getItemID()) {
                        subAssetFound = true;
                        final Collection<Asset> subSubAssets = subAsset.getAssets();
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
