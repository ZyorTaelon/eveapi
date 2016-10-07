package com.beimin.eveapi.eve.typename;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.eve.TypeNameParser;
import com.beimin.eveapi.response.eve.TypeNameResponse;

public class TypeNameParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		TypeNameParser parser = new TypeNameParser();
		TypeNameResponse response = parser.getResponse(getTypeID());
		testResponse(response);
	}

}