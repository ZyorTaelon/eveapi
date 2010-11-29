package com.beimin.eveapi.character.mail.bodies;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class MailBodiesParser extends AbstractApiParser<MailBodiesResponse> {
	private static final String MAIL_MESSAGES_URL = "/MailBodies.xml.aspx";

	private MailBodiesParser() {
		super(MailBodiesResponse.class, 2, MAIL_MESSAGES_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiMailBody.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addBeanPropertySetter("eveapi/result/rowset/row", "body");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public MailBodiesResponse getEveMaiResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CHARACTER);
	}

	public Set<ApiMailBody> getEveMails(ApiAuth auth) throws IOException, SAXException {
		return getEveMaiResponse(auth).getMailBodies();
	}

	public static MailBodiesParser getInstance() {
		return new MailBodiesParser();
	}
}