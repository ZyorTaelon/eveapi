package com.beimin.eveapi.handler.calllist;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.calllist.Call;
import com.beimin.eveapi.model.calllist.CallGroup;
import com.beimin.eveapi.model.shared.KeyType;
import com.beimin.eveapi.response.calllist.CallListResponse;

public class CallListHandler extends AbstractContentHandler<CallListResponse> {
    private boolean callGroups;
    private boolean calls;

    public CallListHandler() {
        super(new CallListResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, ATTRIBUTE_NAME);
            if ("callGroups".equals(name)) {
                callGroups = true;
            } else if ("calls".equals(name)) {
                calls = true;
            }
        } else if (ELEMENT_ROW.equals(qName)) {
            if (callGroups) {
                final CallGroup callGroup = new CallGroup();
                saveAttributes(CallGroup.class, attrs);
                callGroup.setGroupID(getInt(attrs, "groupID"));
                callGroup.setName(getString(attrs, ATTRIBUTE_NAME));
                callGroup.setDescription(getString(attrs, "description"));
                getResponse().add(callGroup);
            } else if (calls) {
                final Call call = new Call();
                saveAttributes(Call.class, attrs);
                call.setAccessMask(getLong(attrs, "accessMask"));
                call.setType(KeyType.valueOf(getString(attrs, "type").toUpperCase(Locale.ENGLISH)));
                call.setName(getString(attrs, ATTRIBUTE_NAME));
                call.setGroupID(getInt(attrs, "groupID"));
                call.setDescription(getString(attrs, "description"));
                getResponse().add(call);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            callGroups = false;
            calls = false;
        }
    }
}
