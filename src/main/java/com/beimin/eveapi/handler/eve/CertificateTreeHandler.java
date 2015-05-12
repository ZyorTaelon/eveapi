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
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset")) {
			String name = getString(attrs, "name");
			if (name.equals("categories"))
				categories = true;
			else if (name.equals("classes"))
				classes = true;
			else if (name.equals("certificates"))
				certificates = true;
			else if (name.equals("requiredSkills"))
				requiredSkills = true;
			else if (name.equals("requiredCertificates"))
				requiredCertificates = true;
		} else if (qName.equals("row")) {
			 if (requiredSkills) {
				RequiredSkill skill = new RequiredSkill();
				skill.setTypeID(getInt(attrs, "typeID"));
				skill.setLevel(getInt(attrs, "level"));
				certificate.add(skill);
			} else if (requiredCertificates) {
				RequiredCertificate cert = new RequiredCertificate();
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
		} else
			super.startElement(uri, localName, qName, attrs);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset")) {
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
		} else if (qName.equals("row")) {
			if (requiredSkills || requiredCertificates) {
				// skip.
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
		} else 
			super.endElement(uri, localName, qName);
	}
	
	@Override
	protected CertificateCategory getItem(Attributes attrs) {
		CertificateCategory item = new CertificateCategory();
		item.setCategoryID(getInt(attrs, "categoryID"));
		item.setCategoryName(getString(attrs, "categoryName"));
		return item;
	}
}