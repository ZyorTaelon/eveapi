package com.beimin.eveapi.corporation.member.tracking;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberTrackingParser;
import com.beimin.eveapi.response.corporation.MemberTrackingResponse;
import org.junit.Ignore;

public class TrackingParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("New fields test not working")
    public void getResponse() throws Exception {
        //Not included in default return
        addNullOk("getLocation");
        addNullOk("getShipType");
        addNullOk("getBaseID");
        addNullOk("getLogonDateTime");
        addNullOk("getBase");
        addNullOk("getLogoffDateTime");
        addEmptyOK("getGrantableRoles");
        addEmptyOK("getTitle");
        addEmptyOK("getLocationID");
        addEmptyOK("getRoles");
        addEmptyOK("getShipTypeID");
        final MemberTrackingParser parser = new MemberTrackingParser();
        final MemberTrackingResponse response = parser.getResponse(getCorp());
        testResponse(response);
    }

    @Test @Ignore("Some data missing")
    public void getExtendedResponse() throws Exception {
        final MemberTrackingParser parser = new MemberTrackingParser();
        final MemberTrackingResponse response = parser.getExtendedResponse(getCorp());
        testResponse(response);
    }

}
