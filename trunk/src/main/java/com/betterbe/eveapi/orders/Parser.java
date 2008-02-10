package com.betterbe.eveapi.orders;

import org.apache.commons.digester.Digester;

import com.betterbe.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser {

	private Digester getDigester() {
		Digester digester = super.getDigester(Response.class);
		// create digester here.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
