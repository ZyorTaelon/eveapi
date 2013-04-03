package com.beimin.eveapi.shared.character;

//import org.apache.commons.beanutils.Converter;

public class EveAncestryConverter {// implements Converter {
	@SuppressWarnings("rawtypes")
	public Object convert(Class type, Object value) {
		return EveAncestry.valueOf(((String) value).toUpperCase().replaceAll("[-\\s]", "_"));
	}
}