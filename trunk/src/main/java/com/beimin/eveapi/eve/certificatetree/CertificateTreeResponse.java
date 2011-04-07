package com.beimin.eveapi.eve.certificatetree;

import com.beimin.eveapi.core.ApiListResponse;

public class CertificateTreeResponse extends ApiListResponse<ApiCertificateCategory> {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		String result = "";
		for (ApiCertificateCategory certificateCategory : getAll())
			result += certificateCategory + "\n";
		return result;
	}
}