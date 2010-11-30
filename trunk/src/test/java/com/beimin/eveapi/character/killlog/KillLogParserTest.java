package com.beimin.eveapi.character.killlog;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;
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
import com.beimin.eveapi.shared.killlog.AbstractKillLogParser;
import com.beimin.eveapi.shared.killlog.ApiKill;
import com.beimin.eveapi.shared.killlog.ApiKillAttacker;
import com.beimin.eveapi.shared.killlog.ApiKillItem;
import com.beimin.eveapi.shared.killlog.ApiKillVictim;
import com.beimin.eveapi.shared.killlog.KillLogResponse;
import com.beimin.eveapi.utils.MockApi;

public class KillLogParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/char/KillLog.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("456", req.getParameter("characterID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/character/KillLog.xml"));
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
	public void killLogParser() throws IOException, SAXException {
		AbstractKillLogParser parser = KillLogParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 456, "abc");
		KillLogResponse response = parser.getKillLogResponse(auth);
		assertNotNull(response);
		Collection<ApiKill> entries = response.getKills();
		assertEquals(18, entries.size());
		boolean found = false;
		for (ApiKill kill : entries) {
			if (kill.getKillID() == 4879947) {
				found = true;
				assertDate(2008, 12, 18, 23, 57, 0, kill.getKillTime());
				ApiKillVictim victim = kill.getVictim();
				assertNotNull(victim);

				assertEquals(victim.getCharacterID(), 411109620);
				assertEquals(victim.getCharacterName(), "Pi'rat Tealon");
				assertEquals(victim.getCorporationID(), 1449814438);
				assertEquals(victim.getCorporationName(), "The Bastards");
				assertEquals(victim.getAllianceID().longValue(), 1311549668L);
				assertEquals(victim.getAllianceName(), "The Bastards.");
				assertEquals(victim.getFactionID(), 0);
				assertEquals(victim.getFactionName(), "");
				assertEquals(victim.getDamageTaken(), 1415);
				assertEquals(victim.getShipTypeID(), 587);

				List<ApiKillAttacker> attackers = kill.getAttackers();
				assertNotNull(attackers);
				assertEquals(1, attackers.size());
				ApiKillAttacker attacker = attackers.iterator().next();
				assertEquals(attacker.getCharacterID(), 1134301496);
				assertEquals(attacker.getCharacterName(), "Blackfiredaemon");
				assertEquals(attacker.getCorporationID(), 1885670269);
				assertEquals(attacker.getCorporationName(), "Letiferi Praedones");
				assertEquals(attacker.getAllianceID().longValue(), 1652934118L);
				assertEquals(attacker.getAllianceName(), "Wong Thong Crew");
				assertEquals(attacker.getFactionID(), 0);
				assertEquals(attacker.getFactionName(), "");
				assertEquals(attacker.getSecurityStatus(), -3.72675620703378, 1E-15);
				assertEquals(attacker.getDamageDone(), 1415);
				assertEquals(attacker.isFinalBlow(), true);
				assertEquals(attacker.getWeaponTypeID(), 2897);
				assertEquals(attacker.getShipTypeID(), 11999);

				List<ApiKillItem> items = kill.getItems();
				assertNotNull(items);
				assertEquals(12, items.size());
			}
		}
		assertTrue("test KillLog entry wasn't found.", found);
	}
}