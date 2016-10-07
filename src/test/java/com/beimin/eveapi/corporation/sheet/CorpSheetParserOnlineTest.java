package com.beimin.eveapi.corporation.sheet;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.CorpSheetParser;
import com.beimin.eveapi.response.corporation.CorpSheetResponse;

public class CorpSheetParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		//Not in alliance
		addNullOk("getAllianceName");
		addEmptyOK("getAllianceID");
		addEmptyOK("getFactionID");
		//No Tax
		addEmptyOK("getTaxRate");
		//Valid zero
		addEmptyOK("getGraphicID");
		CorpSheetParser parser = new CorpSheetParser();
		CorpSheetResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}