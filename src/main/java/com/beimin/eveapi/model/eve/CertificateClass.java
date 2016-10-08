package com.beimin.eveapi.model.eve;

import java.util.ArrayList;
import java.util.List;

public class CertificateClass {
    private final List<Certificate> certificates = new ArrayList<Certificate>();
    private int classID;
    private String className;

    public void add(final Certificate certificate) {
        certificates.add(certificate);
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(final int classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(final String className) {
        this.className = className;
    }
}
