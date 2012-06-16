package com.beimin.eveapi.character.industryjobs;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.industryjobs.AbstractIndustryJobsParser;
import com.beimin.eveapi.shared.industryjobs.ApiIndustryJob;
import com.beimin.eveapi.shared.industryjobs.IndustryJobsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class IndustryJobsParserTest extends FullAuthParserTest {
	public IndustryJobsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.INDUSTRY_JOBS);
	}

	@Test
	public void getResponse() throws ApiException {
		AbstractIndustryJobsParser parser = IndustryJobsParser.getInstance();
		IndustryJobsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<ApiIndustryJob> industryJobs = response.getAll();
		assertNotNull(industryJobs);
		assertEquals(5, industryJobs.size());
		boolean found = false;
		for (ApiIndustryJob job : industryJobs) {
			if (job.getJobID() == 23264063) {
				found = true;
				assertEquals(100518790L, job.getAssemblyLineID());
				assertEquals(1386493620, job.getContainerID());
				assertEquals(1002502594, job.getInstalledItemID());
				assertEquals(199583646, job.getInstalledItemLocationID());
				assertEquals(1, job.getInstalledItemQuantity());
				assertEquals(12, job.getInstalledItemProductivityLevel());
				assertEquals(40, job.getInstalledItemMaterialLevel());
				assertEquals(-1, job.getInstalledItemLicensedProductionRunsRemaining());
				assertEquals(1386493620, job.getOutputLocationID());
				assertEquals(674831735, job.getInstallerID());
				assertEquals(6, job.getRuns());
				assertEquals(15, job.getLicensedProductionRuns());
				assertEquals(30005005, job.getInstalledInSolarSystemID());
				assertEquals(30005005, job.getContainerLocationID());
				assertEquals(1, job.getMaterialMultiplier());
				assertEquals(1, job.getCharMaterialMultiplier());
				assertEquals(0.65, job.getTimeMultiplier(), 0.5);
				assertEquals(1.5, job.getCharTimeMultiplier(), 0.5);
				assertEquals(971, job.getInstalledItemTypeID());
				assertEquals(971, job.getOutputTypeID());
				assertEquals(28351, job.getContainerTypeID());
				assertEquals(0, job.getInstalledItemCopy());
				assertFalse(job.isCompleted());
				assertFalse(job.isCompletedSuccessfully());
				assertEquals(121, job.getInstalledItemFlag());
				assertEquals(120, job.getOutputFlag());
				assertEquals(5, job.getActivityID());
				assertEquals(0, job.getCompletedStatus());
				assertDate(2008, 5, 23, 00, 38, 0, job.getInstallTime());
				assertDate(2008, 5, 23, 00, 38, 0, job.getBeginProductionTime());
				assertDate(2008, 6, 8, 16, 47, 0, job.getEndProductionTime());
				assertDate(1, 1, 1, 0, 0, 0, job.getPauseProductionTime());
			}
		}
		assertTrue("test job wasn't found.", found);
	}
}