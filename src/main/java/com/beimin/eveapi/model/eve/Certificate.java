package com.beimin.eveapi.model.eve;

import java.util.ArrayList;
import java.util.List;

public class Certificate {
    private int certificateID;
    private int grade;
    private long corporationID;
    private String description;
    private final List<RequiredSkill> requiredSkills = new ArrayList<RequiredSkill>();
    private final List<RequiredCertificate> requiredCertificates = new ArrayList<RequiredCertificate>();

    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(final int certificateID) {
        this.certificateID = certificateID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(final int grade) {
        this.grade = grade;
    }

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final long corporationID) {
        this.corporationID = corporationID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void add(final RequiredSkill requirement) {
        requiredSkills.add(requirement);
    }

    public void add(final RequiredCertificate requirement) {
        requiredCertificates.add(requirement);
    }

    public List<RequiredSkill> getRequiredSkills() {
        return requiredSkills;
    }

    public List<RequiredCertificate> getRequiredCertificates() {
        return requiredCertificates;
    }
}
