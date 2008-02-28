package com.beimin.eveapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

public abstract class AbstractApiParser<E extends ApiResponse> {
	protected static final String EVE_API_URL = "http://api.eve-online.com";
	protected static final String CORP_PATH = "/corp";
	protected static final String CHAR_PATH = "/char";
	private final Class<E> clazz;
	protected final Map<String, E> cache = new HashMap<String, E>();

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

	protected boolean isCached(String requestUrl) {
		return cache.containsKey(requestUrl) && cache.get(requestUrl).getCachedUntil().after(Calendar.getInstance().getTime());
	}

	@SuppressWarnings("unchecked")
	protected E getResponse(String requestUrl, Digester digester) throws IOException, SAXException {
		if (isCached(requestUrl))
			return cache.get(requestUrl);
		E response = (E) digester.parse(requestUrl);
		if (!response.hasError())
			cache.put(requestUrl, response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public E getResponse(InputStream input) throws IOException, SAXException {
		Digester digester = getDigester();
		E response = (E) digester.parse(input);
		return response;
	}
}
