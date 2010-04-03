package com.beimin.eveapi.eve.certificatetree;

import java.util.ArrayList;
import java.util.List;

public class ApiCertificateCategory {
	private final List<ApiCertificateClass> certificateClasses = new ArrayList<ApiCertificateClass>();
	private int categoryID;
	private String categoryName;
	
	public void addCertificateClass(ApiCertificateClass certificateClass) {
		certificateClasses.add(certificateClass);
	}
	
	public List<ApiCertificateClass> getCertificateClasses() {
		return certificateClasses;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}