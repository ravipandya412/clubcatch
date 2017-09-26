package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.y */
class C0185y {
    static String m88a(C0184x c0184x, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0184x.ch());
        if (c0184x.cj() > 0) {
            long cj = j - c0184x.cj();
            if (cj >= 0) {
                stringBuilder.append("&qt").append("=").append(cj);
            }
        }
        stringBuilder.append("&z").append("=").append(c0184x.ci());
        return stringBuilder.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    static Map<String, String> m89s(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
