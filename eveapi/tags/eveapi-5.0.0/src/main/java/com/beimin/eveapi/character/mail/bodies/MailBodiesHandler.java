package com.beimin.eveapi.character.mail.bodies;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class MailBodiesHandler extends AbstractContentListHandler<MailBodiesResponse, ApiMailBody> {
	private ApiMailBody mailBody;

	public MailBodiesHandler() {
		super(MailBodiesResponse.class);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("row")) {
			mailBody = getItem(attrs);
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("row")) {
			mailBody.setBody(getString());
			response.add(mailBody);
			mailBody = null;
			accumulator.setLength(0);
		}
		super.endElement(uri, localName, qName);
	}

	@Override
	protected ApiMailBody getItem(Attributes attrs) {
		ApiMailBody item = new ApiMailBody();
		item.setMessageID(getLong(attrs, "messageID"));
		return item;
	}
}