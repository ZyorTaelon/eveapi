package com.beimin.eveapi.character.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
import com.beimin.eveapi.shared.contacts.ApiContact;
import com.beimin.eveapi.shared.contacts.ContactList;
import com.beimin.eveapi.utils.MockApi;

public class ContactListParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/char/ContactList.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("456", req.getParameter("characterID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/character/ContactList.xml"));
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
		ContactListParser parser = ContactListParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 456, "abc");
		ContactListResponse response = parser.getContactListResponse(auth);
		assertNotNull(response);

		ContactList contactList = response.getContactList();
		assertEquals("contactList", contactList.getName());
		assertEquals(106, contactList.size());
		ApiContact apiContact = contactList.iterator().next();
		assertEquals(3008667, apiContact.getContactID());
		assertEquals("Falian Khivad", apiContact.getContactName());
		assertEquals(5.0, apiContact.getStanding(), 1E-15);
		assertFalse(apiContact.isInWatchlist());

		apiContact = contactList.get(contactList.size() - 1);
		assertEquals(2065725204, apiContact.getContactID());
		assertEquals("De Boer", apiContact.getContactName());
		assertEquals(10.0, apiContact.getStanding(), 1E-15);
		assertTrue(apiContact.isInWatchlist());
	}
}