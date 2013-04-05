package com.beimin.eveapi.character.notifications.texts;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class NotificationTextsHandler extends AbstractContentListHandler<NotificationTextsResponse, ApiNotificationText> {

	private ApiNotificationText notificationText;

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
	protected ApiNotificationText getItem(Attributes attrs) {
		ApiNotificationText notificationText = new ApiNotificationText();
		notificationText.setNotificationID(getLong(attrs, "notificationID"));
		return notificationText;
	}
}