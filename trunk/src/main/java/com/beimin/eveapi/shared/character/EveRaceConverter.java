package com.beimin.eveapi.shared.character;

import org.apache.commons.beanutils.Converter;

public class EveRaceConverter implements Converter {
	@SuppressWarnings("rawtypes")
	public Object convert(Class type, Object value) {
		return EveRace.valueOf(((String) value).toUpperCase().replaceAll("-", "_"));
	}
}