package com.beimin.eveapi.utils.reftypes;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiRefType> refTypes = new ArrayList<ApiRefType>();

	public void addRefType(ApiRefType refType) {
		refTypes.add(refType);
	}

	public Collection<ApiRefType> getRefTypes() {
		return refTypes;
	}
}