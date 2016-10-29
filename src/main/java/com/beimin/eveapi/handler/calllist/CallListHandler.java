package com.beimin.eveapi.handler.calllist;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.calllist.Call;
import com.beimin.eveapi.model.calllist.CallGroup;
import com.beimin.eveapi.model.calllist.CallList;
import com.beimin.eveapi.model.shared.KeyType;
import com.beimin.eveapi.response.calllist.CallListResponse;

public class CallListHandler extends AbstractContentHandler<CallListResponse> {
    private boolean callGroups;
    private boolean calls;
    private CallList callList;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new CallListResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if ("result".equals(qName)) {
            callList = new CallList();
        }
        if (ELEMENT_ROWSET.equals(qName)) {
            setCurrentClass(CallList.class);
            final String name = getString(attrs, ATTRIBUTE_NAME);
            if ("callGroups".equals(name)) {
                callGroups = true;
            } else if ("calls".equals(name)) {
                calls = true;
            }
        }
        if (ELEMENT_ROW.equals(qName)) {
            if (callGroups) {
                final CallGroup callGroup = new CallGroup();
                saveAttributes(CallGroup.class, attrs);
                callGroup.setGroupID(getInt(attrs, "groupID"));
                callGroup.setName(getString(attrs, ATTRIBUTE_NAME));
                callGroup.setDescription(getString(attrs, "description"));
                callList.add(callGroup);
            } else if (calls) {
                final Call call = new Call();
                saveAttributes(Call.class, attrs);
                call.setAccessMask(getLong(attrs, "accessMask"));
                call.setType(KeyType.valueOf(getString(attrs, "type")));
                call.setName(getString(attrs, ATTRIBUTE_NAME));
                call.setGroupID(getInt(attrs, "groupID"));
                call.setDescription(getString(attrs, "description"));
                callList.add(call);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if ("result".equals(qName)) {
            getResponse().set(callList);
        }
        if (ELEMENT_ROWSET.equals(qName)) {
            callGroups = false;
            calls = false;
        }
    }
}
