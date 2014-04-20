package com.beimin.eveapi.map.jumps;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class JumpsParser extends AbstractListParser<JumpsHandler, JumpsResponse, ApiSystemJumps> {
	public JumpsParser() {
		super(JumpsResponse.class, 2, ApiPath.MAP, ApiPage.JUMPS, JumpsHandler.class);
	}

	@Override
	public JumpsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}