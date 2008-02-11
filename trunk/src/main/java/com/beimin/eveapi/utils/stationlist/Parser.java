package com.beimin.eveapi.utils.stationlist;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {

	public Parser() {
		super(Response.class);
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
