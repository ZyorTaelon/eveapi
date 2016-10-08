package com.beimin.eveapi.handler;

import java.io.Serializable;
import java.util.Date;

import com.beimin.eveapi.utils.DateUtils;

public class ApiError implements Serializable {
    private static final long serialVersionUID = 137057814306371822L;

    private int code;
    private String error;
    private Date retryAfterDate;

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
        final int retryIndex = error.indexOf("retry after ");
        if (retryIndex > 0) {
            final int beginIndex = retryIndex + 12;
            final String substring = error.substring(beginIndex, beginIndex + 19);
            retryAfterDate = DateUtils.getGMTConverter().convert(Date.class, substring);
        }
    }

    public boolean hasRetryAfterDate() {
        return retryAfterDate != null;
    }

    public Date getRetryAfterDate() {
        return retryAfterDate;
    }

    @Override
    public String toString() {
        return code + ": " + error;
    }
}
