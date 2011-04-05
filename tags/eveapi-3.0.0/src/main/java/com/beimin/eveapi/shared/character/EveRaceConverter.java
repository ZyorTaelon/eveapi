package com.beimin.eveapi.shared.character;

import org.apache.commons.beanutils.Converter;

public class EveRaceConverter implements Converter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		return EveRace.valueOf(((String) value).toUpperCase().replaceAll("-", "_"));
	}
}