package com.beimin.eveapi.account.characters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import com.beimin.eveapi.utils.MockApi;

public class CharactersParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/account/Characters.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/account/Characters.xml"));
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
	public void testCharacterListParser() throws IOException, SAXException {
		CharactersParser parser = CharactersParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 0, "abc");
		CharactersResponse response = parser.getEveCharacters(auth);
		assertNotNull(response);
		Collection<ApiCharacter> eveCharacters = response.getEveCharacters();
		assertEquals(2, eveCharacters.size());
		for (ApiCharacter eveCharacter : eveCharacters) {
			long characterID = eveCharacter.getCharacterID();
			if (characterID == 46135126) {
				assertEquals("Test Character 1", eveCharacter.getName());
				assertEquals(71643215, eveCharacter.getCorporationID());
				assertEquals("Emipre Alt corp", eveCharacter.getCorporationName());
			} else if (characterID == 416541356) {
				assertEquals("Test Character 2", eveCharacter.getName());
				assertEquals(416513245, eveCharacter.getCorporationID());
				assertEquals("Deepspace Explorations", eveCharacter.getCorporationName());
			} else {
				fail();
			}
		}
	}
}