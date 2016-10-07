package com.beimin.eveapi.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class CamelUtils {
    /**
     * Work-around for bug described in: http://mail-archives.apache.org/mod_mbox/camel-users/201010.mbox/%3c4CC94149.8000800@catify.com
     *
     * Note that the issue is not resolved in camel 2.6.0, so the version has not been changed from 2.5.0.
     *
     * @param in
     * @return a map of POST parameters.
     */
    public static Map<String, String> parsePostParams(final String in) {
        final Map<String, String> postParams = new HashMap<String, String>();

        for (final String kvs : in.split("&")) {
            final String[] kv = kvs.split("=");
            if (kv.length == 2) {
                try {
                    postParams.put(URLDecoder.decode(kv[0], "UTF-8"), URLDecoder.decode(kv[1], "UTF-8"));
                } catch (final UnsupportedEncodingException mue) {
                    throw new RuntimeException(mue);
                }
            }
        }

        return postParams;
    }
}
