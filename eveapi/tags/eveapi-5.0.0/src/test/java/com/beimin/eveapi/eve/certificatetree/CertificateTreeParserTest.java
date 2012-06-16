package com.beimin.eveapi.eve.certificatetree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CertificateTreeParserTest extends NoAuthParserTest {
	public CertificateTreeParserTest() {
		super(ApiPath.EVE, ApiPage.CERTIFICATE_TREE);
	}

	@Test
	public void getResponse() throws ApiException {
		CertificateTreeParser parser = CertificateTreeParser.getInstance();
		CertificateTreeResponse response = parser.getResponse();
		assertNotNull("Should have returned a response.", response);
		assertEquals("version 2 expected.", 2, response.getVersion());
		assertNotNull("Response should contain the current time.", response.getCurrentTime());
		assertNotNull("Response should contain the time untill this response data is cached.", response.getCachedUntil());
		Set<ApiCertificateCategory> certificateCategories = response.getAll();
		assertEquals("Wrong number of Certificate Categories", 11, certificateCategories.size());
		ApiCertificateCategory certificateCategory = certificateCategories.iterator().next();
		assertEquals(3, certificateCategory.getCategoryID());
		assertEquals("Core", certificateCategory.getCategoryName());
		List<ApiCertificateClass> certificateClasses = certificateCategory.getCertificateClasses();
		assertEquals("Wrong number of Certificate Classes", 6, certificateClasses.size());
		ApiCertificateClass certificateClass = certificateClasses.iterator().next();
		assertEquals(2, certificateClass.getClassID());
		assertEquals("Core Fitting", certificateClass.getClassName());
		List<ApiCertificate> certificates = certificateClass.getCertificates();
		assertEquals("Wrong number of Certificates", 4, certificates.size());
		Iterator<ApiCertificate> iterator = certificates.iterator();
		iterator.next();
		ApiCertificate certificate = iterator.next();
		assertEquals(6, certificate.getCertificateID());
		assertEquals(2, certificate.getGrade());
		assertEquals(1000125, certificate.getCorporationID());
		assertEquals(
				"This certificate represents a standard level of competence in fitting ships. It certifies that the holder is able to use Micro Auxiliary Power Cores and many Tech 2 fitting modules. The holder knows that MAPCs are the best way to increase power output on Frigate-class ships. This provides you with a broad range of fitting options",
				certificate.getDescription());
		List<RequiredSkill> requiredSkills = certificate.getRequiredSkills();
		assertEquals("Wrong number of required skills", 5, requiredSkills.size());
		RequiredSkill requiredSkill = requiredSkills.iterator().next();
		assertEquals(3318, requiredSkill.getTypeID());
		assertEquals(4, requiredSkill.getLevel());
		List<RequiredCertificate> requiredCertificates = certificate.getRequiredCertificates();
		assertEquals("Wrong number of required certificates", 1, requiredCertificates.size());
		RequiredCertificate requiredCertificate = requiredCertificates.iterator().next();
		assertEquals(5, requiredCertificate.getCertificateID());
		assertEquals(1, requiredCertificate.getGrade());
	}
}