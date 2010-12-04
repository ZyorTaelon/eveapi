package com.beimin.eveapi;

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

import com.beimin.eveapi.utils.MockApi;

public abstract class FullApiParserTest {
	private static final CamelContext context = new DefaultCamelContext();
	private String apiUrl;
	private String returnXmlFile;
	protected ApiAuth auth = new ApiAuthorization(123, 456, "abc");

	public FullApiParserTest(String apiUrl, String returnXmlFile) {
		this.apiUrl = apiUrl;
		this.returnXmlFile = returnXmlFile;
	}

	@Before
	public void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + apiUrl).process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("456", req.getParameter("characterID"));
						assertEquals("abc", req.getParameter("apiKey"));
						extraAsserts(req);
						exchange.getOut().setBody(MockApi.response(returnXmlFile));
					}
				});
			}
		});
		context.start();
		AbstractApiParser.setEveApiURL(MockApi.URL);
	}

	protected void extraAsserts(HttpServletRequest req) {
		// overridable
	}

	@After
	public void cleanup() throws Exception {
		context.stop();
	}
}