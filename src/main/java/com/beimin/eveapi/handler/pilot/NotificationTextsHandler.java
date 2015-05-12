package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.NotificationText;
import com.beimin.eveapi.response.pilot.NotificationTextsResponse;

public class NotificationTextsHandler extends AbstractContentListHandler<NotificationTextsResponse, NotificationText> {

	private NotificationText notificationText;

	public NotificationTextsHandler() {
		super(NotificationTextsResponse.class);
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("row")) {
			notificationText = getItem(attrs);
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("row")) {
			notificationText.setText(getString());
			response.add(notificationText);
			notificationText = null;
			accumulator.setLength(0);
		}
		super.endElement(uri, localName, qName);
	}
	
	@Override
	protected NotificationText getItem(Attributes attrs) {
		NotificationText notificationText = new NotificationText();
		notificationText.setNotificationID(getLong(attrs, "notificationID"));
		return notificationText;
	}
}