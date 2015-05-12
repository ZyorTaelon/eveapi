package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.MailBody;
import com.beimin.eveapi.response.pilot.MailBodiesResponse;

public class MailBodiesHandler extends AbstractContentListHandler<MailBodiesResponse, MailBody> {
	private MailBody mailBody;

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
	protected MailBody getItem(Attributes attrs) {
		MailBody item = new MailBody();
		item.setMessageID(getLong(attrs, "messageID"));
		return item;
	}
}