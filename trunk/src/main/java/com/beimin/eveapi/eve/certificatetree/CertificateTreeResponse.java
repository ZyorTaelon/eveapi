package com.beimin.eveapi.eve.certificatetree;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class CertificateTreeResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiCertificateCategory> certificateCategories = new ArrayList<ApiCertificateCategory>();

	public void addCertificateCategory(
			ApiCertificateCategory certificateCategory) {
		certificateCategories.add(certificateCategory);
	}

	public List<ApiCertificateCategory> getCertificateCategories() {
		return certificateCategories;
	}

	@Override
	public String toString() {
		String result = "";
		for (ApiCertificateCategory certificateCategory : certificateCategories) {
			result += certificateCategory + "\n";
		}
		return result;
	}
}
