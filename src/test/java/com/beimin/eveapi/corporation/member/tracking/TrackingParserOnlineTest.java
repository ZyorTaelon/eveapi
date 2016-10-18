package com.beimin.eveapi.corporation.member.tracking;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.corporation.Member;
import com.beimin.eveapi.parser.corporation.MemberTrackingParser;
import com.beimin.eveapi.response.corporation.MemberTrackingResponse;
import org.junit.Before;

public class TrackingParserOnlineTest extends AbstractOnlineTest {
    final MemberTrackingParser classToTest = new MemberTrackingParser();

    @Before
    public void prepare() {
        before();
        addIgnoreElement("row");
        //Can be empty
        addEmptyOK("getBase");
        addEmptyOK("getTitle");
        addEmptyOK("getBaseID");
        addEmptyOK("getGrantableRoles");

        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        //Not included in default return
        addNullOk("getLocation");
        addNullOk("getShipType");
        addNullOk("getLogonDateTime");
        addNullOk("getLogoffDateTime");
        addEmptyOK("getTitle");
        addEmptyOK("getLocationID");
        addEmptyOK("getRoles");
        addEmptyOK("getShipTypeID");
        
        //location, shipType, logonDateTime, logoffDateTime
        //grantableRoles, locationID, roles, shipTypeID
        addElementMissingOK(Member.class, 8);
        
        
        final MemberTrackingResponse response = classToTest.getResponse(getCorp());

        testResponse(response);
    }

    @Test
    public void getExtendedResponse() throws Exception {
        final MemberTrackingResponse response = classToTest.getExtendedResponse(getCorp());

        testResponse(response);
    }
}
