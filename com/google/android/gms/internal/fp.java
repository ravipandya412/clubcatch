package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import com.pkr.clubcatch.C0519R;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fp {
    private static final Pattern CO;
    private static final Pattern CP;

    static {
        CO = Pattern.compile("\\\\.");
        CP = Pattern.compile("[\\\\\"/\b\f\n\r\t]");
    }

    public static String ap(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = CP.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    matcher.appendReplacement(stringBuffer, "\\\\b");
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    matcher.appendReplacement(stringBuffer, "\\\\t");
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    matcher.appendReplacement(stringBuffer, "\\\\n");
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    matcher.appendReplacement(stringBuffer, "\\\\f");
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    matcher.appendReplacement(stringBuffer, "\\\\r");
                    break;
                case C0519R.styleable.Theme_actionModePasteDrawable /*34*/:
                    matcher.appendReplacement(stringBuffer, "\\\\\\\"");
                    break;
                case C0519R.styleable.Theme_spinnerDropDownItemStyle /*47*/:
                    matcher.appendReplacement(stringBuffer, "\\\\/");
                    break;
                case C0519R.styleable.Theme_alertDialogTheme /*92*/:
                    matcher.appendReplacement(stringBuffer, "\\\\\\\\");
                    break;
                default:
                    break;
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean m776d(Object obj, Object obj2) {
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!jSONObject2.has(str)) {
                    return false;
                }
                try {
                    if (!m776d(jSONObject.get(str), jSONObject2.get(str))) {
                        return false;
                    }
                } catch (JSONException e) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            return obj.equals(obj2);
        } else {
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (jSONArray.length() != jSONArray2.length()) {
                return false;
            }
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    if (!m776d(jSONArray.get(i), jSONArray2.get(i))) {
                        return false;
                    }
                    i++;
                } catch (JSONException e2) {
                    return false;
                }
            }
            return true;
        }
    }
}
