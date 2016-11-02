package com.beimin.eveapi.model.pilot;

import java.util.Date;

public class ChatChannelExtendedAccessor extends ChatChannelAccessor {
    private Date untilWhen;
    private String reason;

    public Date getUntilWhen() {
        return untilWhen;
    }

    public void setUntilWhen(Date untilWhen) {
        this.untilWhen = untilWhen;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ChatChannelExtendedAccessor [untilWhen=" + untilWhen + ", reason=" + reason + ", getAccessorID()=" + getAccessorID() + ", getAccessorName()=" + getAccessorName() + "]";
    }
}
