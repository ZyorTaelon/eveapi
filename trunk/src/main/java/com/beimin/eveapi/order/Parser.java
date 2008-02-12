package com.beimin.eveapi.order;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create Market Orders digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}