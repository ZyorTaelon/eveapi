package com.beimin.eveapi.member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String MEMBER_TRACKING_URL = "/corp/MemberTracking.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getMembers(ApiAuth auth) throws IOException, SAXException {
		String requestUrl = getRequestUrl(auth);
		return getResponse(requestUrl, getDigester());
	}

	protected String getRequestUrl(ApiAuth auth) throws UnsupportedEncodingException {
		String requestUrl = EVE_API_URL;
		requestUrl += MEMBER_TRACKING_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=1";
		return requestUrl;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", Member.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addMember");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}