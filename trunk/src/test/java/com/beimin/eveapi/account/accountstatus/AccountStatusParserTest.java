package com.beimin.eveapi.account.accountstatus;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiAuthorization;
import com.beimin.eveapi.utils.MockApi;

public class AccountStatusParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/account/AccountStatus.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/account/AccountStatus.xml"));
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
	public void testMockAPI() throws Exception {
		AccountStatusParser accountStatusParser = AccountStatusParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 0, "abc");
		AccountStatusResponse response = accountStatusParser.getAccountStatus(auth);
		assertNotNull(response);
		assertEquals(541354, response.getUserID());
		assertDate(2011, 03, 13, 18, 40, 0, response.getPaidUntil());
		assertDate(2004, 07, 22, 23, 54, 0, response.getCreateDate());
		assertEquals(5603, response.getLogonCount());
		assertEquals(504903, response.getLogonMinutes());
	}
}