package com.betterbe.eveapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

public abstract class AbstractApiParser<E extends ApiResponse> {
	private final Class<E> clazz;

	public AbstractApiParser(Class<E> clazz) {
		this.clazz = clazz;
	}

	protected Digester getDigester() {
		Digester digester = new Digester();
		DateLocaleConverter converter = new DateLocaleConverter(Locale.getDefault(), "yyyy-MM-dd HH:mm:ss");
		converter.setLenient(true);
		ConvertUtils.register(converter, java.util.Date.class);
		digester.setValidating(false);
		digester.addObjectCreate("eveapi", clazz);
		digester.addSetProperties("eveapi");
		digester.addObjectCreate("eveapi/error", ApiError.class);
		digester.addSetProperties("eveapi/error");
		digester.addBeanPropertySetter("eveapi/error");
		digester.addSetNext("eveapi/error", "setError");
		digester.addBeanPropertySetter("eveapi/currentTime");
		digester.addBeanPropertySetter("eveapi/cachedUntil");
		return digester;
	}

	@SuppressWarnings("unchecked")
	public E getResponse(InputStream input) throws IOException, SAXException {
		Digester digester = getDigester();
		E response = (E) digester.parse(input);
		return response;
	}
}
