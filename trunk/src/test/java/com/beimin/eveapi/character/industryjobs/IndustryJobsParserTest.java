package com.beimin.eveapi.character.industryjobs;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;
import com.beimin.eveapi.shared.industryjobs.ApiIndustryJob;
import com.beimin.eveapi.shared.industryjobs.IndustryJobsResponse;

public class IndustryJobsParserTest {

	@Test
	public void industryJobsParser() throws IOException, SAXException, ParseException {
		AbstractIndustryJobsParser parser = IndustryJobsParser.getInstance();
		InputStream input = IndustryJobsParserTest.class.getResourceAsStream("/character/IndustryJobs.xml");
		IndustryJobsResponse response = parser.getResponse(input);
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