package com.beimin.eveapi.utils.reftypes;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<RefType> refTypes = new ArrayList<RefType>();

	public void addRefType(RefType refType) {
		refTypes.add(refType);
	}

	public Collection<RefType> getRefTypes() {
		return refTypes;
	}
}