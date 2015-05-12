package com.beimin.eveapi.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.response.ApiListResponse;
import com.beimin.eveapi.response.ApiResponse;

public abstract class AbstractContentListHandler<E extends ApiListResponse<B>, B> extends AbstractContentHandler {
	private final Class<E> clazz;
	protected E response;

	public AbstractContentListHandler(Class<E> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void startDocument() throws SAXException {
		try {
			response = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("row")) {
			response.add(getItem(attrs));
		}
		super.startElement(uri, localName, qName, attrs);
	}
	
	protected abstract B getItem(Attributes attrs);

	@Override
	public ApiResponse getResponse() {
		return response;
	}
}