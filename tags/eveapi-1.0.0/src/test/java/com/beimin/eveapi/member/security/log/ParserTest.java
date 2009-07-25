package com.beimin.eveapi.member.security.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.member.security.ApiSecurityRole;

public class ParserTest {

	@Test
	public void testMemberTrackingParser() throws IOException, SAXException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/MemberSecurityLog.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		Set<ApiRoleHistory> roleHistories = response.getRoleHistories();
		assertNotNull(roleHistories);
		assertEquals("Incorrect amount of role histories found.", 4, roleHistories.size());
		boolean found = false;
		for (ApiRoleHistory roleHistory : roleHistories) {
			if (roleHistory.getCharacterName().equals("Tester1")) {
				found = true;
				Set<ApiSecurityRole> oldRoles = roleHistory.getOldRoles();
				assertEquals("Incorrect amount of old roles found.", 8, oldRoles.size());
				boolean oldRoleFound = false;
				for (ApiSecurityRole securityRole : oldRoles) {
					if (securityRole.getRoleID() == 4194304) {
						oldRoleFound = true;
						assertEquals("Wrong old role name.", "roleHangarCanQuery3", securityRole.getRoleName());
					}
				}
				assertTrue("Test old role not found. ", oldRoleFound);
				Set<ApiSecurityRole> newRoles = roleHistory.getNewRoles();
				assertEquals("Incorrect amount of old roles found.", 0, newRoles.size());
			}
		}
		assertTrue("Test role history not found. ", found);
	}
}