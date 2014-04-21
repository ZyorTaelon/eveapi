package com.beimin.eveapi.eve.character;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Test;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.parser.ApiAuthorization;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.eve.CharacterInfoParser;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;
import com.beimin.eveapi.utils.ExchangeProcessor;
import com.beimin.eveapi.utils.MockApi;

public class CharacterInfoParserTest {
	private final ApiPath path = ApiPath.EVE;
	private final ApiPage page = ApiPage.CHARACTER_INFO;
	private final ApiAuthorization limitedAPI = new ApiAuthorization(123, 1380128241, "abc");
	private final ApiAuthorization fullAPI = new ApiAuthorization(123, 1380128241, "abcdef");

	@Test
	public void parserTestWithoutAuth() throws Exception {
		CamelContext context = new DefaultCamelContext();

		context.addRoutes(noAPI);
		context.start();
		EveApi.setConnector(new ApiConnector(MockApi.URL));
		CharacterInfoParser parser = new CharacterInfoParser();
		CharacterInfoResponse response = parser.getResponse(1380128241);
		assertNotNull(response);
		assertEquals(1380128241L, response.getCharacterID());
		assertEquals("Zy'or Tealon", response.getCharacterName());
		assertEquals(Race.CALDARI, response.getRace());
		assertEquals(Bloodline.DETEIS, response.getBloodline());
		assertEquals(217940508L, response.getCorporationID());
		assertEquals("Black  Mesa", response.getCorporation());
		assertDate(2010, 8, 23, 20, 29, 0, response.getCorporationDate());
		assertEquals(786554367L, response.getAllianceID().longValue());
		assertEquals("Wayfarer Stellar Initiative", response.getAlliance());
		assertDate(2010, 11, 22, 00, 57, 0, response.getAllianceDate());
		assertEquals(1.74600960835429, response.getSecurityStatus(), 0.00001);
		assertEquals(5, response.getEmploymentHistory().size());

		assertNull(response.getSkillPoints());
		assertNull(response.getShipName());
		assertNull(response.getShipTypeID());
		assertNull(response.getShipTypeName());

		assertNull(response.getAccountBalance());
		assertNull(response.getLastKnownLocation());
		context.stop();
	}

	@Test
	public void parserTestWithLimitedAPI() throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(limitedApiRoute);
		context.start();
		EveApi.setConnector(new ApiConnector(MockApi.URL));
		CharacterInfoParser parser = new CharacterInfoParser();
		CharacterInfoResponse response = parser.getResponse(limitedAPI);
		assertNotNull(response);
		assertEquals(1380128241L, response.getCharacterID());
		assertEquals("Zy'or Tealon", response.getCharacterName());
		assertEquals(Race.CALDARI, response.getRace());
		assertEquals(Bloodline.DETEIS, response.getBloodline());
		assertEquals(217940508L, response.getCorporationID());
		assertEquals("Black  Mesa", response.getCorporation());
		assertDate(2010, 8, 23, 20, 29, 0, response.getCorporationDate());
		assertEquals(786554367L, response.getAllianceID().longValue());
		assertEquals("Wayfarer Stellar Initiative", response.getAlliance());
		assertDate(2010, 11, 22, 00, 57, 0, response.getAllianceDate());
		assertEquals(1.74600960835429, response.getSecurityStatus(), 0.00001);

		assertEquals(88793781, response.getSkillPoints().intValue());
		assertEquals("Zy'or", response.getShipName());
		assertEquals(24696, response.getShipTypeID().intValue());
		assertEquals("Harbinger", response.getShipTypeName());

		assertNull(response.getAccountBalance());
		assertNull(response.getLastKnownLocation());
		context.stop();
	}

	@Test
	public void parserTestWithFullAPI() throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(fullApiRoute);
		context.start();
		EveApi.setConnector(new ApiConnector(MockApi.URL));
		CharacterInfoParser parser = new CharacterInfoParser();
		CharacterInfoResponse response = parser.getResponse(fullAPI);
		assertNotNull(response);
		assertEquals(1380128241L, response.getCharacterID());
		assertEquals("Zy'or Tealon", response.getCharacterName());
		assertEquals(Race.AMARR, response.getRace());
		assertEquals(Bloodline.NI_KUNNI, response.getBloodline());
		assertEquals(217940508L, response.getCorporationID());
		assertEquals("Black  Mesa", response.getCorporation());
		assertDate(2010, 8, 23, 20, 29, 0, response.getCorporationDate());
		assertEquals(786554367L, response.getAllianceID().longValue());
		assertEquals("Wayfarer Stellar Initiative", response.getAlliance());
		assertDate(2010, 11, 22, 00, 57, 0, response.getAllianceDate());
		assertEquals(1.74600960835429, response.getSecurityStatus(), 0.00001);

		assertEquals(88793781, response.getSkillPoints().intValue());
		assertEquals("Zy'or", response.getShipName());
		assertEquals(24696, response.getShipTypeID().intValue());
		assertEquals("Harbinger", response.getShipTypeName());

		assertEquals(37040036.46, response.getAccountBalance().doubleValue(), 0.01);
		assertEquals("OC The Revolving Door", response.getLastKnownLocation());
		context.stop();
	}

	private final RouteBuilder limitedApiRoute = new RouteBuilder() {
		@Override
		public void configure() {
			from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx").process(
					new ExchangeProcessor(new ExchangeProcessor.ExtraAsserts() {
						public void extraAsserts(Map<String, String> params) {
							assertNotNull(params);
							assertEquals("123", params.get("keyID"));
							assertEquals("1380128241", params.get("characterID"));
							assertEquals("abc", params.get("vCode"));
						}
					}, path.getPath() + "/" + page.getPage() + "_LimitedAPI.xml")).end();
		}
	};

	private final RouteBuilder noAPI = new RouteBuilder() {
		@Override
		public void configure() {
			from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx").process(
					new ExchangeProcessor(new ExchangeProcessor.ExtraAsserts() {
						public void extraAsserts(Map<String, String> params) {
							assertNotNull(params);
							assertEquals("1380128241", params.get("characterID"));
						}
					}, path.getPath() + "/" + page.getPage() + "_NoAPI.xml")).end();
		}
	};

	private final RouteBuilder fullApiRoute = new RouteBuilder() {
		@Override
		public void configure() {
			from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx").process(
					new ExchangeProcessor(new ExchangeProcessor.ExtraAsserts() {
						public void extraAsserts(Map<String, String> params) {
							assertNotNull(params);
							assertEquals("123", params.get("keyID"));
							assertEquals("1380128241", params.get("characterID"));
							assertEquals("abcdef", params.get("vCode"));
						}
					}, path.getPath() + "/" + page.getPage() + "_FullAPI.xml")).end();
		}
	};
}