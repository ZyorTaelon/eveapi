package com.beimin.eveapi.corporation.member.medals;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.MemberMedal;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.MemberMedalsParser;
import com.beimin.eveapi.response.corporation.MemberMedalsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class MedalsParserTest extends FullAuthParserTest {
    public MedalsParserTest() {
        super(ApiPath.CORPORATION, ApiPage.MEMBER_MEDALS);
    }

    @Test
    public void getResponse() throws ApiException {
        final MemberMedalsParser parser = new MemberMedalsParser();
        final MemberMedalsResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final List<MemberMedal> memberMedals = response.getAll();
        assertNotNull(memberMedals);
        assertEquals(45, memberMedals.size());
        final MemberMedal memberMedal = memberMedals.iterator().next();
        assertEquals(1745, memberMedal.getMedalID());
        assertEquals(264288979L, memberMedal.getCharacterID());
        assertEquals("Ooy late night op", memberMedal.getReason());
        assertTrue("Should have been public", memberMedal.isPublic());
        assertEquals(817217271L, memberMedal.getIssuerID());
        assertDate(2008, 11, 12, 7, 39, 28, memberMedal.getIssued());
    }
}
