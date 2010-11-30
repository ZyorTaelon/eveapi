package com.beimin.eveapi.character.industryjobs;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;
import com.beimin.eveapi.shared.industryjobs.ApiIndustryJob;
import com.beimin.eveapi.shared.industryjobs.IndustryJobsResponse;
import com.beimin.eveapi.utils.MockApi;

public class IndustryJobsParserTest {
	private static final CamelContext context = new DefaultCamelContext();

	@BeforeClass
	public static void setup() throws Exception {
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jetty:" + MockApi.URL + "/char/IndustryJobs.xml.aspx").process(new Processor() {
					public void process(Exchange exchange) {
						HttpServletRequest req = exchange.getIn().getBody(HttpServletRequest.class);
						assertNotNull(req);
						assertEquals("123", req.getParameter("userID"));
						assertEquals("456", req.getParameter("characterID"));
						assertEquals("abc", req.getParameter("apiKey"));
						exchange.getOut().setBody(MockApi.response("/character/IndustryJobs.xml"));
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
	public void industryJobsParser() throws IOException, SAXException {
		AbstractIndustryJobsParser parser = IndustryJobsParser.getInstance();
		ApiAuth auth = new ApiAuthorization(123, 456, "abc");
		IndustryJobsResponse response = parser.getIndustryJobsResponse(auth);
		assertNotNull(response);
		Collection<ApiIndustryJob> industryJobs = response.getIndustryJobs();
		assertNotNull(industryJobs);
		assertEquals(22, industryJobs.size());
		boolean found = false;
		for (ApiIndustryJob job : industryJobs) {
			if (job.getJobID() == 444) {
				found = true;
				assertEquals(60010783, job.getContainerID());
				assertEquals(150438239, job.getInstalledItemID());
				assertEquals(60010783, job.getInstalledItemLocationID());
				assertEquals(1, job.getInstalledItemQuantity());
				assertEquals(0, job.getInstalledItemProductivityLevel());
				assertEquals(0, job.getInstalledItemMaterialLevel());
				assertEquals(300, job.getInstalledItemLicensedProductionRunsRemaining());
				assertEquals(60010783, job.getOutputLocationID());
				assertEquals(150208955, job.getInstallerID());
				assertEquals(1, job.getRuns());
				assertEquals(10, job.getLicensedProductionRuns());
				assertEquals(30004969, job.getInstalledInSolarSystemID());
				assertEquals(30004969, job.getContainerLocationID());
				assertEquals(-4, job.getMaterialMultiplier());
				assertEquals(1, job.getCharMaterialMultiplier());
				assertEquals(-4, job.getTimeMultiplier());
				assertEquals(1, job.getCharTimeMultiplier());
				assertEquals(1079, job.getInstalledItemTypeID());
				assertEquals(1080, job.getOutputTypeID());
				assertEquals(3869, job.getContainerTypeID());
				assertEquals(1, job.getInstalledItemCopy());
				assertEquals(0, job.getCompleted());
				assertEquals(0, job.getCompletedSuccessfully());
				assertEquals(4, job.getInstalledItemFlag());
				assertEquals(4, job.getOutputFlag());
				assertEquals(8, job.getActivityID());
				assertEquals(0, job.getCompletedStatus());
				assertDate(2007, 11, 30, 11, 59, 0, job.getInstallTime());
				assertDate(2007, 11, 30, 11, 59, 0, job.getBeginProductionTime());
				assertDate(2007, 11, 30, 14, 29, 0, job.getEndProductionTime());
				assertDate(1, 1, 1, 0, 0, 0, job.getPauseProductionTime());
			}
		}
		assertTrue("test job wasn't found.", found);
	}
}