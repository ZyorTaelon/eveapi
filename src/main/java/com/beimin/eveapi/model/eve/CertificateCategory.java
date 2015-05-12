package com.beimin.eveapi.model.eve;

import java.util.ArrayList;
import java.util.List;

public class CertificateCategory {
	private final List<CertificateClass> certificateClasses = new ArrayList<CertificateClass>();
	private int categoryID;
	private String categoryName;
	
	public void add(CertificateClass certificateClass) {
		certificateClasses.add(certificateClass);
	}
	
	public List<CertificateClass> getCertificateClasses() {
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