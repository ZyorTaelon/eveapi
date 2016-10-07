package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.eve.Certificate;
import com.beimin.eveapi.model.eve.CertificateCategory;
import com.beimin.eveapi.model.eve.CertificateClass;
import com.beimin.eveapi.model.eve.RequiredCertificate;
import com.beimin.eveapi.model.eve.RequiredSkill;
import com.beimin.eveapi.response.eve.CertificateTreeResponse;

public class CertificateTreeHandler extends AbstractContentListHandler<CertificateTreeResponse, CertificateCategory> {
    private boolean categories;
    private boolean classes;
    private boolean certificates;
    private boolean requiredSkills;
    private boolean requiredCertificates;
    private CertificateCategory category;
    private CertificateClass certificateClass;
    private Certificate certificate;

    public CertificateTreeHandler() {
        super(CertificateTreeResponse.class);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, "name");
            if (name.equals("categories")) {
                categories = true;
            } else if (name.equals("classes")) {
                classes = true;
            } else if (name.equals("certificates")) {
                certificates = true;
            } else if (name.equals("requiredSkills")) {
                requiredSkills = true;
            } else if (name.equals("requiredCertificates")) {
                requiredCertificates = true;
            }
        } else if (ELEMENT_ROW.equals(qName)) {
            if (requiredSkills) {
                final RequiredSkill skill = new RequiredSkill();
                skill.setTypeID(getInt(attrs, "typeID"));
                skill.setLevel(getInt(attrs, "level"));
                certificate.add(skill);
            } else if (requiredCertificates) {
                final RequiredCertificate cert = new RequiredCertificate();
                cert.setCertificateID(getInt(attrs, "certificateID"));
                cert.setGrade(getInt(attrs, "grade"));
                certificate.add(cert);
            } else if (certificates) {
                certificate = new Certificate();
                certificate.setCertificateID(getInt(attrs, "certificateID"));
                certificate.setCorporationID(getLong(attrs, "corporationID"));
                certificate.setDescription(getString(attrs, "description"));
                certificate.setGrade(getInt(attrs, "grade"));
            } else if (classes) {
                certificateClass = new CertificateClass();
                certificateClass.setClassID(getInt(attrs, "classID"));
                certificateClass.setClassName(getString(attrs, "className"));
            } else if (categories) {
                category = getItem(attrs);
            }
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            if (requiredSkills) {
                requiredSkills = false;
            } else if (requiredCertificates) {
                requiredCertificates = false;
            } else if (certificates) {
                certificates = false;
            } else if (classes) {
                classes = false;
            } else if (categories) {
                categories = false;
            }
        } else if (ELEMENT_ROW.equals(qName)) {
            if (requiredSkills || requiredCertificates) {
                return;
            } else if (certificates) {
                certificateClass.add(certificate);
                certificate = null;
            } else if (classes) {
                category.add(certificateClass);
                certificateClass = null;
            } else if (categories) {
                response.add(category);
                category = null;
            }
        } else {
            super.endElement(uri, localName, qName);
        }
    }

    @Override
    protected CertificateCategory getItem(final Attributes attrs) {
        final CertificateCategory item = new CertificateCategory();
        item.setCategoryID(getInt(attrs, "categoryID"));
        item.setCategoryName(getString(attrs, "categoryName"));
        return item;
    }
}
