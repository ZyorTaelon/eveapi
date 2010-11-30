package com.beimin.eveapi.character.contacts;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

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
import com.beimin.eveapi.utils.MockApi;

public class ContactNotificationsParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/char/ContactNotifications.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("456", req.getParameter("characterID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/character/ContactNotifications.xml"));
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
	public void contactListParser() throws IOException, SAXException {
		ContactNotificationsParser parser = ContactNotificationsParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 456, "abc");
		ContactNotificationsResponse response = parser.getContactNotificationsResponse(auth);
		assertNotNull(response);
		List<ApiContactNotification> contactNotifications = response.getContactNotifications();
		assertEquals(1, contactNotifications.size());
		ApiContactNotification contactNotification = contactNotifications.iterator().next();
		assertEquals(308734131, contactNotification.getNotificationID());
		assertEquals(797400947L, contactNotification.getSenderID());
		assertEquals("CCP Garthagk", contactNotification.getSenderName());
		assertDate(2010, 5, 29, 23, 4, 0, contactNotification.getSentDate());
		assertEquals("level: 10\nmessage: Hi, I want to social network with you!\n", contactNotification.getMessageData());
	}
}