package com.beimin.eveapi.character.industryjobs;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.IndustryJob;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.IndustryJobsParser;
import com.beimin.eveapi.parser.shared.AbstractIndustryJobsParser;
import com.beimin.eveapi.response.shared.IndustryJobsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class IndustryJobsParserTest extends FullAuthParserTest {
	public IndustryJobsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.INDUSTRY_JOBS);
	}

	@Test
	public void getResponse() throws ApiException {
		AbstractIndustryJobsParser parser = new IndustryJobsParser();
		IndustryJobsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<IndustryJob> industryJobs = response.getAll();
		assertNotNull(industryJobs);
		assertEquals(4, industryJobs.size());
		boolean found = false;
		for (IndustryJob job : industryJobs) {
			if (job.getJobID() == 231459965) {
				found = true;
				assertEquals(1111111111, job.getInstallerID());
				assertEquals("Paul", job.getInstallerName());
				assertEquals(1015487453710l, job.getFacilityID());
				assertEquals(30066314l, job.getSolarSystemID());
				assertEquals("Jita", job.getSolarSystemName());
				assertEquals(1231455343453l, job.getStationID());
				assertEquals(1, job.getActivityID());
				assertEquals(1009259615294l, job.getBlueprintID());
				assertEquals(12220, job.getBlueprintTypeID());
				assertEquals("Capital Remote Capacitor Transmitter I Blueprint", job.getBlueprintTypeName());
				assertEquals(1015487453710l, job.getBlueprintLocationID());
				assertEquals(1015487453710l, job.getOutputLocationID());
				assertEquals(18, job.getRuns());
				assertEquals(132213.00d, job.getCost(), 0.01);
				assertEquals(0, job.getTeamID());
				assertEquals(5, job.getLicensedRuns());
				assertEquals(0, job.getProbability());
				assertEquals(0, job.getProductTypeID());
				assertEquals("", job.getProductTypeName());
				assertEquals(1, job.getStatus());
				assertEquals(15790, job.getTimeInSeconds());
				assertDate(2014, 7, 31, 18, 31, 31, job.getStartDate());
				assertDate(2014, 7, 31, 22, 54, 41, job.getEndDate());
				assertDate(0001, 1, 1, 0, 0, 0, job.getPauseDate());
				assertDate(0001, 1, 1, 0, 0, 0, job.getCompletedDate());
				assertEquals(0, job.getCompletedCharacterID());
			}
		}
		assertTrue("test job wasn't found.", found);
	}
}