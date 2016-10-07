package com.beimin.eveapi.corporation.starbase.detail;


import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.model.corporation.Starbase;
import com.beimin.eveapi.parser.corporation.StarbaseDetailParser;
import com.beimin.eveapi.parser.corporation.StarbaseListParser;
import com.beimin.eveapi.response.corporation.StarbaseDetailResponse;

import org.junit.Test;

import com.beimin.eveapi.response.corporation.StarbaseListResponse;
import java.util.Set;
public class StarbaseDetailParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		StarbaseListParser starbaseListParser = new StarbaseListParser();
		StarbaseListResponse starbaseListResponse = starbaseListParser.getResponse(getCorp());
		Set<Starbase> starbases = starbaseListResponse.getAll();
		test(starbases);
		StarbaseDetailParser parser = new StarbaseDetailParser();
		for (Starbase starbase : starbases) {
			StarbaseDetailResponse response = parser.getResponse(getCorp(), starbase.getItemID());
			testResponse(response);
		}
	}

}