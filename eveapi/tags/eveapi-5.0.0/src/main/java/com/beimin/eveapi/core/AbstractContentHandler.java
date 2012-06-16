package com.beimin.eveapi.core;

import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.beimin.eveapi.utils.DateUtils;

public abstract  class AbstractContentHandler extends DefaultHandler {
	protected StringBuffer accumulator = new StringBuffer(); // Accumulate parsed text
	private ApiError error;

	@Override
	public void characters(char[] buffer, int start, int length) {
		accumulator.append(buffer, start, length);
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs)
			throws SAXException {
		if (qName.equals("eveapi")) {
			getResponse().setVersion(getInt(attrs, "version"));
		} else if (qName.equals("error")) {
			error = new ApiError();
			error.setCode(getInt(attrs, "code"));
			getResponse().setError(error);
		}
		accumulator.setLength(0);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("currentTime"))
			getResponse().setCurrentTime(getDate());
		else if (qName.equals("cachedUntil"))
			getResponse().setCachedUntil(getDate());
		else if (qName.equals("error"))
			error.setError(getString());
	}

	protected String getString() {
		return accumulator.toString().trim();
	}

	protected String getString(Attributes attrs, String qName) {
		return attrs.getValue(qName);
	}

	protected Date getDate() {
		return getDate(getString());
	}

	protected Date getDate(String string) {
		return DateUtils.getGMTConverter().convert(Date.class, string);
	}

	protected Date getDate(Attributes attrs, String qName) {
		return getDate(getString(attrs, qName));
	}

	protected Integer getInt() {
		try {
			return Integer.parseInt(getString());
		} catch (NumberFormatException e) {
			return null;
		}
	}

	protected Integer getInt(Attributes attrs, String qName) {
		try {
			return Integer.parseInt(getString(attrs, qName));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	protected Long getLong() {
		try {
			return Long.parseLong(getString());
		} catch (NumberFormatException e) {
			return null;
		}
	}

	protected Long getLong(Attributes attrs, String qName) {
		try {
			return Long.parseLong(getString(attrs, qName));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	protected Double getDouble() {
		try {
			return Double.parseDouble(getString());
		} catch (NumberFormatException e) {
			return null;
		}
	}

	protected Double getDouble(Attributes attrs, String qName) {
		try {
			return Double.parseDouble(getString(attrs, qName));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	protected boolean getBoolean() {
		return getString().equals("1") || "true".equalsIgnoreCase(getString());
	}

	protected boolean getBoolean(Attributes attrs, String qName) {
		return "1".equals(getString(attrs, qName)) || "true".equalsIgnoreCase(getString(attrs, qName));
	}
	
	public abstract ApiResponse getResponse();
}