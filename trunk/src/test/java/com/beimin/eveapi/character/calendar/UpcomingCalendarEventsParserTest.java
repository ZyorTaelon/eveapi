package com.beimin.eveapi.character.calendar;

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
import com.beimin.eveapi.character.calendar.upcomingevents.ApiUpcomingCalendarEvent;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsParser;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsResponse;
import com.beimin.eveapi.utils.MockApi;

public class UpcomingCalendarEventsParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/char/UpcomingCalendarEvents.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/character/UpcomingCalendarEvents.xml"));
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
	public void testUpcomingCalendarEventsParser() throws IOException, SAXException {
		UpcomingCalendarEventsParser parser = UpcomingCalendarEventsParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 0, "abc");
		UpcomingCalendarEventsResponse response = parser.getUpcomingCalendarEvents(auth);
		List<ApiUpcomingCalendarEvent> events = response.getUpcomingCalendarEvents();
		assertEquals(1, events.size());
		ApiUpcomingCalendarEvent event = events.iterator().next();
		assertEquals(90864, event.getEventID());
		assertEquals(786344537L, event.getOwnerID());
		assertEquals("Some Alliance", event.getOwnerName());
		assertDate(2010, 11, 28, 17, 00, 00, event.getEventDate());
		assertEquals("Some Mining OP @ 17:00", event.getEventTitle());
		assertEquals(true, event.isImportant());
		assertEquals("Undecided", event.getResponse());
		assertEquals(
				"Alliance Mining OP Part II<br><br>This will be in home system the sunday after the patch..<br>We would really like to see as many mining barges out there as possible. PVPers are also needed for security.. See you there!!!",
				event.getEventText());
	}
}