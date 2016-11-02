package com.beimin.eveapi.corporation.sheet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.corporation.CorpLogo;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.CorpSheetParser;
import com.beimin.eveapi.response.corporation.CorpSheetResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CorpSheetParserTest extends FullAuthParserTest {
    public CorpSheetParserTest() {
        super(ApiPath.CORPORATION, ApiPage.CORPORATION_SHEET);
    }

    @Test
    public void getResponse() throws ApiException {
        final CorpSheetParser parser = new CorpSheetParser();
        final CorpSheetResponse response = parser.getResponse(auth);
        assertNotNull(response);
        assertEquals(150212025, response.getCorporationID());
        assertEquals("Banana Republic", response.getCorporationName());
        assertEquals("BR", response.getTicker());
        assertEquals(150208955, response.getCeoID());
        assertEquals("Mark Roled", response.getCeoName());
        assertEquals(60003469, response.getStationID());
        assertEquals("Jita IV - Caldari Business Tribunal Information Center", response.getStationName());
        assertEquals("Garth's testing corp of awesome sauce, win sauce as it were. In this\n            corp...<br><br>IT HAPPENS ALL OVER", response.getDescription());
        assertEquals("some url", response.getUrl());
        assertEquals(150430947L, response.getAllianceID().longValue());
        assertEquals(500004, response.getFactionID().longValue());
        assertEquals(93.7, response.getTaxRate(), 0.0001);
        assertEquals(3, response.getMemberCount());
        assertEquals(6300, response.getMemberLimit());
        assertEquals(1, response.getShares());
        final CorpLogo logo = response.getLogo();
        assertNotNull(logo);
        assertEquals(0, logo.getGraphicID());
        assertEquals(448, logo.getShape1());
        assertEquals(0, logo.getShape2());
        assertEquals(418, logo.getShape3());
        assertEquals(681, logo.getColor1());
        assertEquals(676, logo.getColor2());
        assertEquals(0, logo.getColor3());

        final Map<Integer, String> divisions = response.getDivisions();
        assertEquals("1ST DIVISION", divisions.get(1000));
        assertEquals("2ND DIVISION", divisions.get(1001));
        assertEquals("HELLO", divisions.get(1002));
        assertEquals("DIVISION", divisions.get(1003));
        assertEquals("SWEET", divisions.get(1004));
        assertEquals("6TH DIVISION", divisions.get(1005));
        assertEquals("7TH DIVISION", divisions.get(1006));
        final Map<Integer, String> walletDivisions = response.getWalletDivisions();
        assertEquals("Master Wallet", walletDivisions.get(1000));
        assertEquals("2nd Wallet Division", walletDivisions.get(1001));
        assertEquals("3rd Wallet Division", walletDivisions.get(1002));
        assertEquals("AYE WALLET?", walletDivisions.get(1003));
        assertEquals("5th Wallet Division", walletDivisions.get(1004));
        assertEquals("6th Wallet Division", walletDivisions.get(1005));
        assertEquals("7th Wallet Division", walletDivisions.get(1006));
    }
}
