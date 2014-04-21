package com.beimin.eveapi.parser.map;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.map.JumpsHandler;
import com.beimin.eveapi.model.map.SystemJumps;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.map.JumpsResponse;

public class JumpsParser extends AbstractListParser<JumpsHandler, JumpsResponse, SystemJumps> {
	public JumpsParser() {
		super(JumpsResponse.class, 2, ApiPath.MAP, ApiPage.JUMPS, JumpsHandler.class);
	}

	@Override
	public JumpsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}