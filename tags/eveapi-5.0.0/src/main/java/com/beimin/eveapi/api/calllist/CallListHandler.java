package com.beimin.eveapi.api.calllist;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class CallListHandler extends AbstractContentHandler {
	private CallListResponse response;
	private boolean callGroups = false;
	private boolean calls = false;
	private CallList callList;

	@Override
	public void startDocument() throws SAXException {
		response = new CallListResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs)
			throws SAXException {
		if (qName.equals("result"))
			callList = new CallList();
		if (qName.equals("rowset")) {
			String name = attrs.getValue("name");
			if (name.equals("callGroups")) {
				callGroups = true;
			} else if(name.equals("calls")) {
				calls = true;
			}
		}
		if (qName.equals("row")) {
			if(callGroups) {
				CallGroup callGroup = new CallGroup();
				callGroup.setGroupID(getInt(attrs, "groupID"));
				callGroup.setName(getString(attrs, "name"));
				callGroup.setDescription(getString(attrs, "description"));
				callList.add(callGroup);
			} else if(calls) {
				Call call = new Call();
				call.setAccessMask(getLong(attrs, "accessMask"));
				call.setType(getString(attrs, "type"));
				call.setName(getString(attrs, "name"));
				call.setGroupID(getInt(attrs, "groupID"));
				callList.add(call);
			}
		}
		super.startElement(uri, localName, qName, attrs);
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("result"))
			response.set(callList);
		if (qName.equals("rowset")) {
			callGroups = false;
			calls = false;
		}
		super.endElement(uri, localName, qName);
	}

	@Override
	public CallListResponse getResponse() {
		return response;
	}
}
