package com.beimin.eveapi.corporation.member.tracking;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.corporation.Member;
import com.beimin.eveapi.parser.corporation.MemberTrackingParser;
import com.beimin.eveapi.response.corporation.MemberTrackingResponse;

public class TrackingParserOnlineTest extends AbstractOnlineTest {
    final MemberTrackingParser classToTest = new MemberTrackingParser();

    @Before
    public void prepare() {
        setAlias(MemberTrackingResponse.class, "members", "items");
        // Can be empty
        allowEmpty("getBase");
        allowEmpty("getTitle");
        allowEmpty("getBaseID");
        allowEmpty("getGrantableRoles");

        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        // Not included in default return
        allowNull("getLocation");
        allowNull("getShipType");
        allowNull("getLogonDateTime");
        allowNull("getLogoffDateTime");
        allowEmpty("getTitle");
        allowEmpty("getLocationID");
        allowEmpty("getRoles");
        allowEmpty("getShipTypeID");
        ignoreClassField(Member.class, "location");
        ignoreClassField(Member.class, "shipType");
        ignoreClassField(Member.class, "logonDateTime");
        ignoreClassField(Member.class, "logoffDateTime");
        ignoreClassField(Member.class, "grantableRoles");
        ignoreClassField(Member.class, "locationID");
        ignoreClassField(Member.class, "roles");
        ignoreClassField(Member.class, "shipTypeID");

        final MemberTrackingResponse response = classToTest.getResponse(getCorp());

        testResponse(response);
    }

    @Test
    public void getExtendedResponse() throws Exception {
        final MemberTrackingResponse response = classToTest.getExtendedResponse(getCorp());
        allowEmpty("getRoles");
        testResponse(response);
    }
}
