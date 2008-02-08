package com.betterbe.eveapi;

import java.util.Locale;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.digester.Digester;

public abstract class AbstractApiParser {

	protected <E extends ApiResponse> Digester getDigester(Class<E> clazz) {
		Digester digester = new Digester();
		DateLocaleConverter converter = new DateLocaleConverter(Locale.getDefault(), "yyyy-MM-dd HH:mm:ss");
		converter.setLenient(true);
		ConvertUtils.register(converter, java.util.Date.class);
		digester.setValidating(false);
		digester.addObjectCreate("eveapi", clazz);
		digester.addSetProperties("eveapi");
		digester.addBeanPropertySetter("eveapi/currentTime");
		digester.addBeanPropertySetter("eveapi/cachedUntil");
		return digester;
	}
}
