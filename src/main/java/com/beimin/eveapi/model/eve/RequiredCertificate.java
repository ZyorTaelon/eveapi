package com.beimin.eveapi.model.eve;

public class RequiredCertificate implements CertificateRequirement {
	private int certificateID;
	private int grade;

	public int getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(int certificateID) {
		this.certificateID = certificateID;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}