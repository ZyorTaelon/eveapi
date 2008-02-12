package com.beimin.eveapi.industry;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create Industry Jobs digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}