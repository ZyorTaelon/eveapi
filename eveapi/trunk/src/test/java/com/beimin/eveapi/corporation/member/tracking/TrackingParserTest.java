package com.beimin.eveapi.corporation.member.tracking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.Set;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.ExchangeProcessor;
import com.beimin.eveapi.utils.FullAuthParserTest;
import com.beimin.eveapi.utils.MockApi;

public class TrackingParserTest extends FullAuthParserTest {
	public TrackingParserTest() {
		super(ApiPath.CORPORATION, ApiPage.MEMBER_TRACKING);
	}

	@Test
	public void getResponse() throws ApiException {
		MemberTrackingParser parser = new MemberTrackingParser();
		MemberTrackingResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ApiMember> members = response.getAll();
		boolean found = false;
		for (ApiMember member : members) {
			if(member.getCharacterID()==150336922L) {
				found = true;
				assertEquals("corpexport", member.getName());
				assertNull(member.getLocation());
			}
		}
		assertTrue("Test character not found: ", found);
	}

	@Test
	public void getExtendedResponse() throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(extended);
		context.start();
		MemberTrackingParser parser = new MemberTrackingParser();
		MemberTrackingResponse response = parser.getExtendedResponse(auth);
		assertNotNull(response);
		Set<ApiMember> members = response.getAll();
		boolean found = false;
		for (ApiMember member : members) {
			if(member.getCharacterID()==150336922L) {
				found = true;
				assertEquals("corpexport", member.getName());
				assertEquals("Bourynes VII - Moon 2 - University of Caille School", member.getLocation());
			}
		}
		assertTrue("Test character not found: ", found);
	}
	
	private final RouteBuilder extended = new RouteBuilder() {
		@Override
		public void configure() {
			from("jetty:" + MockApi.URL + path.getPath() + "/" + page.getPage() + ".xml.aspx")
					.process(new ExchangeProcessor(
						new ExchangeProcessor.ExtraAsserts() {
							public void extraAsserts(Map<String, String> params) {
								assertNotNull(params);
								assertEquals("1", params.get("extended"));
							}
						},
						path.getPath() + "/" + page.getPage() + "Extended.xml"
					))
					.end();
		}
	};
}