package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.pkr.clubcatch.C0519R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dz {
    private static final du xE;
    private static final String[] yE;
    private static final String yF;

    static {
        xE = new du("MetadataUtils");
        yE = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
        yF = "yyyyMMdd'T'HHmmss" + yE[0];
    }

    public static Calendar m652V(String str) {
        if (TextUtils.isEmpty(str)) {
            xE.m641b("Input string is empty or null", new Object[0]);
            return null;
        }
        String W = m653W(str);
        if (TextUtils.isEmpty(W)) {
            xE.m641b("Invalid date format", new Object[0]);
            return null;
        }
        String X = m654X(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(X)) {
            W = W + "T" + X;
            str2 = X.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : yF;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(W));
            return instance;
        } catch (ParseException e) {
            xE.m641b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String m653W(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            xE.m641b("Input string is empty or null", new Object[0]);
        } else {
            try {
                str2 = str.substring(0, "yyyyMMdd".length());
            } catch (IndexOutOfBoundsException e) {
                xE.m642c("Error extracting the date: %s", e.getMessage());
            }
        }
        return str2;
    }

    private static String m654X(String str) {
        if (TextUtils.isEmpty(str)) {
            xE.m641b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != "yyyyMMdd".length()) {
            xE.m641b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case C0519R.styleable.Theme_dialogPreferredPadding /*43*/:
                case C0519R.styleable.Theme_actionDropDownStyle /*45*/:
                    return m655Y(substring) ? substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2") : null;
                case C0519R.styleable.Theme_alertDialogButtonGroupStyle /*90*/:
                    return substring.length() == "HHmmss".length() + yE[0].length() ? substring.substring(0, substring.length() - 1) + "+0000" : null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            xE.m641b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean m655Y(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == yE[1].length() + length2 || length == yE[2].length() + length2 || length == length2 + yE[3].length();
    }

    public static String m656a(Calendar calendar) {
        if (calendar == null) {
            xE.m641b("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = yF;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        str = simpleDateFormat.format(calendar.getTime());
        return str.endsWith("+0000") ? str.replace("+0000", yE[0]) : str;
    }

    public static void m657a(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void m658a(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage cT : list) {
                jSONArray.put(cT.cT());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }
}
