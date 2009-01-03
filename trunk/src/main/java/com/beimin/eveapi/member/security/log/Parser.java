package com.beimin.eveapi.member.security.log;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String MEMBER_SECURITY_LOG_URL = "/corp/MemberSecurityLog.xml.aspx";

	public Parser() {
		super(Response.class, 2, MEMBER_SECURITY_LOG_URL);
	}

	public Response getMembers(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: implement parser
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}