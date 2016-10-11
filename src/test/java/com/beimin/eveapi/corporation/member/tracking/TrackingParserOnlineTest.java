package com.beimin.eveapi.corporation.member.tracking;

import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.corporation.MemberTrackingParser;
import com.beimin.eveapi.response.corporation.MemberTrackingResponse;
import org.junit.Before;

public class TrackingParserOnlineTest extends AbstractOnlineTest {
	final MemberTrackingParser classToTest = new MemberTrackingParser();

	@Before
    public void prepare() {
        before();
        prepareParser(classToTest);
    }

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

        final MemberTrackingResponse response = classToTest.getResponse(getCorp());

        testResponse(response);
    }

    @Test @Ignore("Some data missing")
    public void getExtendedResponse() throws Exception {
        final MemberTrackingResponse response = classToTest.getExtendedResponse(getCorp());

        testResponse(response);
    }

}
