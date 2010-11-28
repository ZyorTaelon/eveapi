package com.beimin.eveapi.character.industryjobs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.TimeZone;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;
import com.beimin.eveapi.shared.industryjobs.ApiIndustryJob;
import com.beimin.eveapi.shared.industryjobs.IndustryJobsResponse;

public class IndustryJobsParserTest {

	@Test
	public void industryJobsParser() throws IOException, SAXException,
			ParseException {
		AbstractIndustryJobsParser parser = IndustryJobsParser.getInstance();
		InputStream input = IndustryJobsParserTest.class
				.getResourceAsStream("/character/IndustryJobs.xml");
		IndustryJobsResponse response = parser.getResponse(input);
		assertNotNull(response);
		Collection<ApiIndustryJob> industryJobs = response.getIndustryJobs();
		assertNotNull(industryJobs);
		assertEquals(22, industryJobs.size());
		boolean found = false;
		for (ApiIndustryJob industryJob : industryJobs) {
			if (industryJob.getJobID() == 444) {
				found = true;
				assertEquals(60010783, industryJob.getContainerID());
				assertEquals(150438239, industryJob.getInstalledItemID());
				assertEquals(60010783, industryJob.getInstalledItemLocationID());
				assertEquals(1, industryJob.getInstalledItemQuantity());
				assertEquals(0, industryJob.getInstalledItemProductivityLevel());
				assertEquals(0, industryJob.getInstalledItemMaterialLevel());
				assertEquals(
						300,
						industryJob
								.getInstalledItemLicensedProductionRunsRemaining());
				assertEquals(60010783, industryJob.getOutputLocationID());
				assertEquals(150208955, industryJob.getInstallerID());
				assertEquals(1, industryJob.getRuns());
				assertEquals(10, industryJob.getLicensedProductionRuns());
				assertEquals(30004969,
						industryJob.getInstalledInSolarSystemID());
				assertEquals(30004969, industryJob.getContainerLocationID());
				assertEquals(-4, industryJob.getMaterialMultiplier());
				assertEquals(1, industryJob.getCharMaterialMultiplier());
				assertEquals(-4, industryJob.getTimeMultiplier());
				assertEquals(1, industryJob.getCharTimeMultiplier());
				assertEquals(1079, industryJob.getInstalledItemTypeID());
				assertEquals(1080, industryJob.getOutputTypeID());
				assertEquals(3869, industryJob.getContainerTypeID());
				assertEquals(1, industryJob.getInstalledItemCopy());
				assertEquals(0, industryJob.getCompleted());
				assertEquals(0, industryJob.getCompletedSuccessfully());
				assertEquals(4, industryJob.getInstalledItemFlag());
				assertEquals(4, industryJob.getOutputFlag());
				assertEquals(8, industryJob.getActivityID());
				assertEquals(0, industryJob.getCompletedStatus());
				Calendar calendar = Calendar.getInstance(TimeZone
						.getTimeZone("GMT"));
				calendar.set(Calendar.YEAR, 2007);
				calendar.set(Calendar.MONTH, 10);
				calendar.set(Calendar.DAY_OF_MONTH, 30);
				calendar.set(Calendar.HOUR_OF_DAY, 11);
				calendar.set(Calendar.MINUTE, 59);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(),
						industryJob.getInstallTimeDate());
				assertEquals(calendar.getTime(),
						industryJob.getBeginProductionTimeDate());
				calendar.set(Calendar.HOUR_OF_DAY, 14);
				calendar.set(Calendar.MINUTE, 29);
				assertEquals(calendar.getTime(),
						industryJob.getEndProductionTimeDate());
				calendar.set(Calendar.YEAR, 1);
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				assertEquals(calendar.getTime(),
						industryJob.getPauseProductionTimeDate());
			}
		}
		assertTrue("test job wasn't found.", found);
	}
}