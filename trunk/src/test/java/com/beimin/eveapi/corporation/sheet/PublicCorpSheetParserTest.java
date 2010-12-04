package com.beimin.eveapi.corporation.sheet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class PublicCorpSheetParserTest extends NoAuthParserTest {
	public PublicCorpSheetParserTest() {
		super(ApiPath.CORPORATION, ApiPage.CORPORATION_SHEET, "Public");
	}

	@Test
	public void corporationSheetParser() throws IOException, SAXException {
		CorpSheetParser parser = CorpSheetParser.getInstance();
		CorpSheetResponse response = parser.getResponse(150333466L);
		assertNotNull(response);
		assertEquals(150333466, response.getCorporationID());
		assertEquals("Marcus Corp", response.getCorporationName());
		assertEquals("MATT2", response.getTicker());
		assertEquals(150302299L, response.getCeoID());
		assertEquals("Marcus", response.getCeoName());
		assertEquals(60003469, response.getStationID());
		assertEquals("Jita IV - Caldari Business Tribunal Information Center", response.getStationName());
		assertEquals("Another Corp", response.getDescription());
		assertEquals("", response.getUrl());
		assertEquals(150382481L, response.getAllianceID().longValue());
		assertEquals("Starbase Anchoring Alliance", response.getAllianceName());
		assertEquals(2.0, response.getTaxRate(), 0.0001);
		assertEquals(1, response.getMemberCount());
		assertEquals(1000, response.getShares());
		ApiCorpLogo logo = response.getLogo();
		assertNotNull(logo);
		assertEquals(0, logo.getGraphicID());
		assertEquals(488, logo.getShape1());
		assertEquals(0, logo.getShape2());
		assertEquals(0, logo.getShape3());
		assertEquals(0, logo.getColor1());
		assertEquals(0, logo.getColor2());
		assertEquals(0, logo.getColor3());
	}

	@Override
	protected void extraAsserts(HttpServletRequest req) {
		assertEquals("150333466", req.getParameter("corporationID"));
	}
}