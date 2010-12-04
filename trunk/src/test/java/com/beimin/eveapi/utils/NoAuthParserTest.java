package com.beimin.eveapi.utils;

import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.After;
import org.junit.Before;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public abstract class NoAuthParserTest {
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
			public void configure() {
				from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						extraAsserts(req);
						exchange.getOut().setBody(MockApi.response(path.getPath() + "/" + page.getPage() + fileSuffix + ".xml"));
					}
				}).end();
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