package com.beimin.eveapi.map.jumps;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class JumpsParser extends AbstractListParser<JumpsHandler, JumpsResponse, ApiSystemJumps> {
	public JumpsParser() {
		super(JumpsResponse.class, 2, ApiPath.MAP, ApiPage.JUMPS, JumpsHandler.class);
	}

	public static JumpsParser getInstance() {
		return new JumpsParser();
	}

	@Override
	public JumpsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}