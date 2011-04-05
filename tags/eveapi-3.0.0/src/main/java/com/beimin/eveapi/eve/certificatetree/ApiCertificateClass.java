package com.beimin.eveapi.eve.certificatetree;

import java.util.ArrayList;
import java.util.List;

public class ApiCertificateClass {
	private final List<ApiCertificate> certificates = new ArrayList<ApiCertificate>();
	private int classID;
	private String className;
	
	public void addCertificate(ApiCertificate certificate) {
		certificates.add(certificate);
	}

	public List<ApiCertificate> getCertificates() {
		return certificates;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}