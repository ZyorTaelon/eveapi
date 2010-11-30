package com.beimin.eveapi.character.accountbalance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.beimin.eveapi.shared.accountbalance.AccountBalanceResponse;
import com.beimin.eveapi.shared.accountbalance.ApiAccountBalance;
import com.beimin.eveapi.utils.MockApi;

public class AccountBalanceParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/char/AccountBalance.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("456", req.getParameter("characterID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/character/AccountBalance.xml"));
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
	public void accountBalanceParser() throws IOException, SAXException {
		AccountBalanceParser parser = AccountBalanceParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 456, "abc");
		AccountBalanceResponse response = parser.getAccountBalanceResponse(auth);
		assertNotNull(response);
		Collection<ApiAccountBalance> accountBalances = response.getAccountBalances();
		assertNotNull(accountBalances);
		assertEquals(1, accountBalances.size());
		ApiAccountBalance accountBalance = accountBalances.iterator().next();
		assertEquals(10094361, accountBalance.getAccountID());
		assertEquals(1000, accountBalance.getAccountKey());
		assertEquals(46634844.84, accountBalance.getBalance(), 0.00001);
	}
}