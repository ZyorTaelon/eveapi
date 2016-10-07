package com.beimin.eveapi.corporation.member.security.log;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.RoleHistory;
import com.beimin.eveapi.model.corporation.SecurityRole;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.MemberSecurityLogParser;
import com.beimin.eveapi.response.corporation.MemberSecurityLogResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class SecurityLogParserTest extends FullAuthParserTest {
    public SecurityLogParserTest() {
        super(ApiPath.CORPORATION, ApiPage.MEMBER_SECURITY_LOG);
    }

    @Test
    public void getResponse() throws ApiException {
        final MemberSecurityLogParser parser = new MemberSecurityLogParser();
        final MemberSecurityLogResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final Set<RoleHistory> roleHistories = response.getAll();
        assertNotNull(roleHistories);
        assertEquals("Incorrect amount of role histories found.", 4, roleHistories.size());
        boolean found = false;
        for (final RoleHistory roleHistory : roleHistories) {
            if (roleHistory.getCharacterName().equals("Tester1")) {
                found = true;
                final Set<SecurityRole> oldRoles = roleHistory.getOldRoles();
                assertEquals("Incorrect amount of old roles found.", 8, oldRoles.size());
                boolean oldRoleFound = false;
                for (final SecurityRole securityRole : oldRoles) {
                    if (securityRole.getRoleID() == 4194304) {
                        oldRoleFound = true;
                        assertEquals("Wrong old role name.", "roleHangarCanQuery3", securityRole.getRoleName());
                    }
                }
                assertTrue("Test old role not found. ", oldRoleFound);
                final Set<SecurityRole> newRoles = roleHistory.getNewRoles();
                assertEquals("Incorrect amount of old roles found.", 0, newRoles.size());
            }
        }
        assertTrue("Test role history not found. ", found);
    }
}
