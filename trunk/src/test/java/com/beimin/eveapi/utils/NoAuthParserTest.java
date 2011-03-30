package com.beimin.eveapi.utils;



import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.After;
import org.junit.Before;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import java.util.Map;

public abstract class NoAuthParserTest implements ExchangeProcessor.ExtraAsserts {
	private final CamelContext context = new DefaultCamelContext();
	private final ApiPath path;
	private final ApiPage page;
	private final String fileSuffix;

	public NoAuthParserTest(ApiPath apiUrl, ApiPage returnXmlFile) {
		this(apiUrl, returnXmlFile, "");
	}

	public NoAuthParserTest(ApiPath path, ApiPage page, String fileSuffix) {
		this.path = path;
		this.page = page;
		this.fileSuffix = fileSuffix;
	}

	@Before
	public void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() {
				
				from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx")
						.process(
							new ExchangeProcessor(
								NoAuthParserTest.this,
								getResourcePath()
							))
						.end();
			}
		});
		context.start();
		EveApi.setConnector(new ApiConnector(MockApi.URL));
	}
	
	protected String getResourcePath() {
		return path.getPath() + "/" + page.getPage() + ".xml";
	}

	protected ApiPage getPage() {
		return page;
	}

	protected ApiPath getPath() {
		return path;
	}

	@Override
	public void extraAsserts(@SuppressWarnings("unused") Map<String, String> req) {
		// overridable
	}

	@After
	public void cleanup() throws Exception {
		context.stop();
	}
}