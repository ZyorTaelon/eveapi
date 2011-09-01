package com.beimin.eveapi.utils;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.After;
import org.junit.Before;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class FullAuthParserTest implements ExchangeProcessor.ExtraAsserts {
	private final CamelContext context = new DefaultCamelContext();
	private final ApiPath path;
	private final ApiPage page;
	private final String resourcePath;
	protected ApiAuthorization auth = new ApiAuthorization(123, 456, "abc");

	/**
	 * Creates the test framework for running tests that require parsing XML.
	 * 
	 * @param path
	 *            The API Path for the request - e.g. 'CHAR' or 'CORP'
	 * @param page
	 *            The individual requested page.
	 */
	public FullAuthParserTest(ApiPath path, ApiPage page) {
		this.path = path;
		this.page = page;
		this.resourcePath = null;
	}

	public FullAuthParserTest(String resourcePath) {
		this.path = null;
		this.page = null;
		this.resourcePath = resourcePath;
	}

	@Before
	public void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() {
				final String resPath;
				if (path != null && page != null && resourcePath == null) {
					resPath = path.getPath() + "/" + page.getPage() + ".xml.aspx";
				} else if (path == null && page == null && resourcePath != null) {
					resPath = resourcePath;
				} else {
					throw new RuntimeException("One of the construction options has been missed: path: " + path
							+ " page: " + " resourcePath: " + resourcePath);
				}

				from("jetty:" + MockApi.URL + resPath)
						.process(
							new ExchangeProcessor(
								FullAuthParserTest.this,
								path.getPath() + "/" + page.getPage() + ".xml"))
						.end();
			}
		});
		context.start();
		EveApi.setConnector(new ApiConnector(MockApi.URL));
	}
  
	@Override
	public void extraAsserts(Map<String, String> req) {
		assertEquals("123", req.get("keyID"));
		assertEquals("456", req.get("characterID"));
		assertEquals("abc", req.get("vCode"));
	}

	@After
	public void cleanup() throws Exception {
		context.stop();
	}
}