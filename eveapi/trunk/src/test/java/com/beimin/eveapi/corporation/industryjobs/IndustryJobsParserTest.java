package com.beimin.eveapi.corporation.industryjobs;

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
		super(ApiPath.CORPORATION, ApiPage.INDUSTRY_JOBS);
	}

	@Test
	public void getResponse() throws ApiException {
		AbstractIndustryJobsParser parser = new CorporationIndustryJobsParser();
		IndustryJobsResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Collection<ApiIndustryJob> industryJobs = response.getAll();
		assertNotNull(industryJobs);
		assertEquals(4, industryJobs.size());
		boolean found = false;
//		<row jobID="23174942" assemblyLineID="100185892" containerID="1080588655" installedItemID="495277991"
//				installedItemLocationID="199583646" installedItemQuantity="1" installedItemProductivityLevel="0"
//				installedItemMaterialLevel="40" installedItemLicensedProductionRunsRemaining="-1" outputLocationID="1080588655"
//				installerID="674831735" runs="18" licensedProductionRuns="0" installedInSolarSystemID="30005005"
//				containerLocationID="30005005" materialMultiplier="1" charMaterialMultiplier="1" timeMultiplier="0.75"
//				charTimeMultiplier="0.75" installedItemTypeID="979" outputTypeID="979" containerTypeID="16216" installedItemCopy="0"
//				completed="0" completedSuccessfully="0" installedItemFlag="118" outputFlag="0" activityID="3" completedStatus="0"
//				installTime="2008-05-21 00:26:00" beginProductionTime="2008-05-21 00:26:00" endProductionTime="2008-06-18 03:26:00"
//				pauseProductionTime="2008-05-25 10:04:00" />
		for (ApiIndustryJob job : industryJobs) {
			if (job.getJobID() == 23174942) {
				found = true;
				assertEquals(100185892, job.getAssemblyLineID());
				assertEquals(1080588655, job.getContainerID());
				assertEquals(495277991, job.getInstalledItemID());
				assertEquals(199583646, job.getInstalledItemLocationID());
				assertEquals(1, job.getInstalledItemQuantity());
				assertEquals(0, job.getInstalledItemProductivityLevel());
				assertEquals(40, job.getInstalledItemMaterialLevel());
				assertEquals(-1, job.getInstalledItemLicensedProductionRunsRemaining());
				assertEquals(1080588655, job.getOutputLocationID());
				assertEquals(674831735, job.getInstallerID());
				assertEquals(18, job.getRuns());
				assertEquals(0, job.getLicensedProductionRuns());
				assertEquals(30005005, job.getInstalledInSolarSystemID());
				assertEquals(30005005, job.getContainerLocationID());
				assertEquals(1.0, job.getMaterialMultiplier(), 0.01);
				assertEquals(1.0, job.getCharMaterialMultiplier(), 0.01);
				assertEquals(0.75, job.getTimeMultiplier(), 0.5);
				assertEquals(0.75, job.getCharTimeMultiplier(), 0.5);
				assertEquals(979, job.getInstalledItemTypeID());
				assertEquals(979, job.getOutputTypeID());
				assertEquals(16216, job.getContainerTypeID());
				assertEquals(0, job.getInstalledItemCopy());
				assertFalse(job.isCompleted());
				assertFalse(job.isCompletedSuccessfully());
				assertEquals(118, job.getInstalledItemFlag());
				assertEquals(0, job.getOutputFlag());
				assertEquals(3, job.getActivityID());
				assertEquals(0, job.getCompletedStatus());
				assertDate(2008, 5, 21, 0, 26, 0, job.getInstallTime());
				assertDate(2008, 5, 21, 0, 26, 0, job.getBeginProductionTime());
				assertDate(2008, 6, 18, 3, 26, 0, job.getEndProductionTime());
				assertDate(2008, 5, 25, 10, 4, 0, job.getPauseProductionTime());
			}
		}
		assertTrue("test job wasn't found.", found);
	}
}