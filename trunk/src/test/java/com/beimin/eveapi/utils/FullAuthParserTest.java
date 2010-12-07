package com.beimin.eveapi.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.After;
import org.junit.Before;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiAuthorization;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class FullAuthParserTest {
	private final CamelContext context = new DefaultCamelContext();
	private final ApiPath path;
	private final ApiPage page;
	protected ApiAuth auth = new ApiAuthorization(123, 456, "abc");

	public FullAuthParserTest(ApiPath path, ApiPage page) {
		this.path = path;
		this.page = page;
	}

	@Before
	public void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() {
				from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx").process(
						new Processor() {
							@Override
							public void process(Exchange exchange) {
								HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
								assertNotNull(req);
								assertEquals("123", req.getParameter("userID"));
								assertEquals("456", req.getParameter("characterID"));
								assertEquals("abc", req.getParameter("apiKey"));
								extraAsserts(req);
								exchange.getOut().setBody(
										MockApi.response(path.getPath() + "/" + page.getPage() + ".xml"));
							}
						}).end();
			}
		});
		context.start();
		EveApi.setConnector(new ApiConnector(MockApi.URL));
	}

	@SuppressWarnings("unused")
	protected void extraAsserts(HttpServletRequest req) {
		// overridable
	}

	@After
	public void cleanup() throws Exception {
		context.stop();
	}
}