package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.pilot.ChatChannel;
import com.beimin.eveapi.model.pilot.ChatChannelAccessor;
import com.beimin.eveapi.model.pilot.ChatChannelExtendedAccessor;
import com.beimin.eveapi.response.pilot.ChatChannelsResponse;

public class ChatChannelsHandler extends AbstractContentHandler<ChatChannelsResponse> {
    private static final String ACCESSOR_ALLOWED = "allowed";
    private static final String ACCESSOR_BLOCKED = "blocked";
    private static final String ACCESSOR_MUTED = "muted";
    private static final String ACCESSOR_OPERATORS = "operators";
    private ChatChannel current;
    private String pos;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new ChatChannelsResponse());
    }

    @Override
    protected void elementStart(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (current == null && ELEMENT_ROW.equals(qName)) {
            saveAttributes(ChatChannel.class, attrs);
            parseChatChannel(attrs);
            getResponse().add(current);
        } else if (current != null && ELEMENT_ROWSET.equals(qName)) {
            pos = getString(attrs, ATTRIBUTE_NAME);
            if (!"channels".equals(pos)) {
                setCurrentClass(ChatChannel.class);
            }
        } else if (pos != null && ELEMENT_ROW.equals(qName)) {
            ChatChannelAccessor accessor = parseAccessor(attrs);
            if (ACCESSOR_ALLOWED.equals(pos)) {
                current.addAllowedAccessor(accessor);
            } else if (ACCESSOR_BLOCKED.equals(pos)) {
                current.addBlockedAccessor((ChatChannelExtendedAccessor) accessor);
            } else if (ACCESSOR_MUTED.equals(pos)) {
                current.addMutedAccessor((ChatChannelExtendedAccessor) accessor);
            } else if (ACCESSOR_OPERATORS.equals(pos)) {
                current.addOperatorAccessor(accessor);
            }
        }
    }

    @Override
    protected void elementEnd(String uri, String localName, String qName) throws SAXException {
        if (pos != null && ELEMENT_ROWSET.equals(qName)) {
            pos = null;
        } else if (pos == null && ELEMENT_ROW.equals(qName)) {
            current = null;
        }
    }

    private ChatChannelAccessor parseAccessor(Attributes attrs) {
        ChatChannelAccessor accessor;
        if (ACCESSOR_BLOCKED.equals(pos) || ACCESSOR_MUTED.equals(pos)) {
            accessor = new ChatChannelExtendedAccessor();
            ((ChatChannelExtendedAccessor) accessor).setReason(getString(attrs, "reason"));
            String date = getString(attrs, "untilWhen");
            if (date != null) {
                ((ChatChannelExtendedAccessor) accessor).setUntilWhen(getDate(date));
            }
            saveAttributes(ChatChannelExtendedAccessor.class, attrs);
        } else {
            accessor = new ChatChannelAccessor();
            saveAttributes(ChatChannelAccessor.class, attrs);
        }
        accessor.setAccessorID(getLong(attrs, "accessorID"));
        accessor.setAccessorName(getString(attrs, "accessorName"));
        return accessor;
    }

    protected void parseChatChannel(Attributes attrs) {
        current = new ChatChannel();
        current.setChannelID(getLong(attrs, "channelID"));
        current.setComparisonKey(getString(attrs, "comparisonKey"));
        current.setDisplayName(getString(attrs, "displayName"));
        current.setHasPassword(getBoolean(attrs, "hasPassword"));
        current.setMotd(getString(attrs, "motd"));
        current.setOwnerID(getLong(attrs, "ownerID"));
        current.setOwnerName(getString(attrs, "ownerName"));
    }
}
