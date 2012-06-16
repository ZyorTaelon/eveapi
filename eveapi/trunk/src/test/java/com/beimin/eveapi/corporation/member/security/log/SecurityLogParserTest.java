package com.beimin.eveapi.corporation.member.security.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.corporation.member.security.ApiSecurityRole;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SecurityLogParserTest extends FullAuthParserTest {
	public SecurityLogParserTest() {
		super(ApiPath.CORPORATION, ApiPage.MEMBER_SECURITY_LOG);
	}

	@Test
	public void getResponse() throws ApiException {
		MemberSecurityLogParser parser = MemberSecurityLogParser.getInstance();
		MemberSecurityLogResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ApiRoleHistory> roleHistories = response.getAll();
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