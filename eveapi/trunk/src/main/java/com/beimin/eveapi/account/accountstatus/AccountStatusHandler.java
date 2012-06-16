package com.beimin.eveapi.account.accountstatus;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class AccountStatusHandler extends AbstractContentHandler {
	private AccountStatusResponse response;
	private EveAccountStatus accountStatus;

	@Override
	public void startDocument() throws SAXException {
		response = new AccountStatusResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		if (qName.equals("result"))
			accountStatus = new EveAccountStatus();
		super.startElement(uri, localName, qName, attributes);
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("userID"))
			accountStatus.setUserID(getInt());
		else if (qName.equals("paidUntil"))
			accountStatus.setPaidUntil(getDate());
		else if (qName.equals("createDate"))
			accountStatus.setCreateDate(getDate());
		else if (qName.equals("logonCount"))
			accountStatus.setLogonCount(getInt());
		else if (qName.equals("logonMinutes"))
			accountStatus.setLogonMinutes(getInt());
		else if (qName.equals("result"))
			response.set(accountStatus);
		super.endElement(uri, localName, qName);
	}

	@Override
	public AccountStatusResponse getResponse() {
		return response;
	}
}
