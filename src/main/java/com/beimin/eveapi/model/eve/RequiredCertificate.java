package com.beimin.eveapi.model.eve;

public class RequiredCertificate implements CertificateRequirement {
    private int certificateID;
    private int grade;

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
}
