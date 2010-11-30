package com.beimin.eveapi.character.assetlist;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiAuthorization;
import com.beimin.eveapi.shared.assetlist.AbstractAssetListParser;
import com.beimin.eveapi.shared.assetlist.ApiAsset;
import com.beimin.eveapi.shared.assetlist.AssetListResponse;
import com.beimin.eveapi.utils.MockApi;

public class AssetListParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/char/AssetList.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("456", req.getParameter("characterID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/character/AssetList.xml"));
					}
				});
			}
		});
		context.start();
		AbstractApiParser.setEveApiURL(MockApi.URL);
	}

	@AfterClass
	public static void cleanup() throws Exception {
		context.stop();
	}

	@Test
	public void testAssetsParser() throws IOException, SAXException {
		AbstractAssetListParser parser = AssetListParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 456, "abc");
		AssetListResponse response = parser.getAssetListResponse(auth);
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