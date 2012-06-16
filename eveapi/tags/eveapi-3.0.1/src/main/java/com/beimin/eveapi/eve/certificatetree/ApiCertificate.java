package com.beimin.eveapi.eve.certificatetree;

import java.util.ArrayList;
import java.util.List;

public class ApiCertificate {
	private int certificateID;
	private int grade;
	private long corporationID;
	private String description;
	private final List<RequiredSkill> requiredSkills = new ArrayList<RequiredSkill>();
	private final List<RequiredCertificate> requiredCertificates = new ArrayList<RequiredCertificate>();

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

	public long getCorporationID() {
		return corporationID;
	}

	public void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addRequirement(CertificateRequirement requirement) {
		if (requirement instanceof RequiredSkill) {
			requiredSkills.add((RequiredSkill) requirement);
		} else if (requirement instanceof RequiredCertificate) {
			requiredCertificates.add((RequiredCertificate) requirement);
		}  
	}

	public List<RequiredSkill> getRequiredSkills() {
		return requiredSkills;
	}

	public List<RequiredCertificate> getRequiredCertificates() {
		return requiredCertificates;
	}
}