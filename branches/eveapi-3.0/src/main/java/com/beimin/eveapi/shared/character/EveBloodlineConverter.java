package com.beimin.eveapi.shared.character;

import org.apache.commons.beanutils.Converter;

public class EveBloodlineConverter implements Converter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		return EveBloodline.valueOf(((String) value).toUpperCase().replaceAll("-", "_"));
	}
}