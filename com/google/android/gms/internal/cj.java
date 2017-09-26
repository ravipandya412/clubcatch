package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cj {
    private static final SimpleDateFormat ow;

    static {
        ow = new SimpleDateFormat("yyyyMMdd");
    }

    public static cf m483a(Context context, cd cdVar, String str) {
        try {
            cf cfVar;
            int i;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString5 = jSONObject.optString("orientation", null);
            int i2 = -1;
            if ("portrait".equals(optString5)) {
                i2 = cv.aU();
            } else if ("landscape".equals(optString5)) {
                i2 = cv.aT();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    da.m570w("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new cf(0);
                }
                cf a = ci.m2524a(context, cdVar.kN.pU, optString2);
                optString = a.nw;
                optString4 = a.oi;
                j = a.oo;
                cfVar = a;
            } else if (TextUtils.isEmpty(optString)) {
                da.m570w("Could not parse the mediation config: Missing required ad_base_url field");
                return new cf(0);
            } else {
                cfVar = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = cfVar == null ? null : cfVar.mt;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = cfVar == null ? null : cfVar.mu;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = cfVar == null ? null : cfVar.om;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (cfVar != null) {
                if (cfVar.orientation != -1) {
                    i2 = cfVar.orientation;
                }
                if (cfVar.oj > 0) {
                    j2 = cfVar.oj;
                }
            }
            return new cf(optString, optString4, list, list2, j2, false, -1, list3, -1, i2, optString3, j);
        } catch (JSONException e) {
            da.m570w("Could not parse the mediation config: " + e.getMessage());
            return new cf(0);
        }
    }

    public static String m484a(cd cdVar, cm cmVar, Location location) {
        try {
            Map hashMap = new HashMap();
            if (cdVar.ob != null) {
                hashMap.put("ad_pos", cdVar.ob);
            }
            m488a((HashMap) hashMap, cdVar.oc);
            hashMap.put("format", cdVar.kQ.ln);
            if (cdVar.kQ.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (cdVar.kQ.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (cdVar.kQ.lp != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (ab abVar : cdVar.kQ.lp) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(abVar.width == -1 ? (int) (((float) abVar.widthPixels) / cmVar.pc) : abVar.width);
                    stringBuilder.append("x");
                    stringBuilder.append(abVar.height == -2 ? (int) (((float) abVar.heightPixels) / cmVar.pc) : abVar.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            hashMap.put("slotname", cdVar.adUnitId);
            hashMap.put("pn", cdVar.applicationInfo.packageName);
            if (cdVar.od != null) {
                hashMap.put("vc", Integer.valueOf(cdVar.od.versionCode));
            }
            hashMap.put("ms", cdVar.oe);
            hashMap.put("seq_num", cdVar.of);
            hashMap.put("session_id", cdVar.og);
            hashMap.put("js", cdVar.kN.pU);
            m487a((HashMap) hashMap, cmVar);
            if (cdVar.oc.versionCode >= 2 && cdVar.oc.ll != null) {
                m485a((HashMap) hashMap, cdVar.oc.ll);
            }
            if (cdVar.versionCode >= 2) {
                hashMap.put("quality_signals", cdVar.oh);
            }
            if (da.m565n(2)) {
                da.m569v("Ad Request JSON: " + cv.m545m(hashMap).toString(2));
            }
            return cv.m545m(hashMap).toString();
        } catch (JSONException e) {
            da.m570w("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    private static void m485a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m486a(HashMap<String, Object> hashMap, am amVar) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(amVar.lI) != 0) {
            hashMap.put("acolor", m490m(amVar.lI));
        }
        if (Color.alpha(amVar.backgroundColor) != 0) {
            hashMap.put("bgcolor", m490m(amVar.backgroundColor));
        }
        if (!(Color.alpha(amVar.lJ) == 0 || Color.alpha(amVar.lK) == 0)) {
            hashMap.put("gradientto", m490m(amVar.lJ));
            hashMap.put("gradientfrom", m490m(amVar.lK));
        }
        if (Color.alpha(amVar.lL) != 0) {
            hashMap.put("bcolor", m490m(amVar.lL));
        }
        hashMap.put("bthick", Integer.toString(amVar.lM));
        switch (amVar.lN) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                obj = "none";
                break;
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                obj = "dashed";
                break;
            case DetectedActivity.ON_FOOT /*2*/:
                obj = "dotted";
                break;
            case DetectedActivity.STILL /*3*/:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (amVar.lO) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                obj2 = "light";
                break;
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                obj2 = "medium";
                break;
            case DetectedActivity.ON_FOOT /*2*/:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (amVar.lP != null) {
            hashMap.put("channel", amVar.lP);
        }
        if (Color.alpha(amVar.lQ) != 0) {
            hashMap.put("dcolor", m490m(amVar.lQ));
        }
        if (amVar.lR != null) {
            hashMap.put("font", amVar.lR);
        }
        if (Color.alpha(amVar.lS) != 0) {
            hashMap.put("hcolor", m490m(amVar.lS));
        }
        hashMap.put("headersize", Integer.toString(amVar.lT));
        if (amVar.lU != null) {
            hashMap.put("q", amVar.lU);
        }
    }

    private static void m487a(HashMap<String, Object> hashMap, cm cmVar) {
        hashMap.put("am", Integer.valueOf(cmVar.oM));
        hashMap.put("cog", m489j(cmVar.oN));
        hashMap.put("coh", m489j(cmVar.oO));
        if (!TextUtils.isEmpty(cmVar.oP)) {
            hashMap.put("carrier", cmVar.oP);
        }
        hashMap.put("gl", cmVar.oQ);
        if (cmVar.oR) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", m489j(cmVar.oS));
        hashMap.put("sp", m489j(cmVar.oT));
        hashMap.put("hl", cmVar.oU);
        if (!TextUtils.isEmpty(cmVar.oV)) {
            hashMap.put("mv", cmVar.oV);
        }
        hashMap.put("muv", Integer.valueOf(cmVar.oW));
        if (cmVar.oX != -2) {
            hashMap.put("cnt", Integer.valueOf(cmVar.oX));
        }
        hashMap.put("gnt", Integer.valueOf(cmVar.oY));
        hashMap.put("pt", Integer.valueOf(cmVar.oZ));
        hashMap.put("rm", Integer.valueOf(cmVar.pa));
        hashMap.put("riv", Integer.valueOf(cmVar.pb));
        hashMap.put("u_sd", Float.valueOf(cmVar.pc));
        hashMap.put("sh", Integer.valueOf(cmVar.pe));
        hashMap.put("sw", Integer.valueOf(cmVar.pd));
    }

    private static void m488a(HashMap<String, Object> hashMap, C0739z c0739z) {
        String aR = cs.aR();
        if (aR != null) {
            hashMap.put("abf", aR);
        }
        if (c0739z.le != -1) {
            hashMap.put("cust_age", ow.format(new Date(c0739z.le)));
        }
        if (c0739z.extras != null) {
            hashMap.put("extras", c0739z.extras);
        }
        if (c0739z.lf != -1) {
            hashMap.put("cust_gender", Integer.valueOf(c0739z.lf));
        }
        if (c0739z.lg != null) {
            hashMap.put("kw", c0739z.lg);
        }
        if (c0739z.tagForChildDirectedTreatment != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(c0739z.tagForChildDirectedTreatment));
        }
        if (c0739z.lh) {
            hashMap.put("adtest", "on");
        }
        if (c0739z.versionCode >= 2) {
            if (c0739z.li) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(c0739z.lj)) {
                hashMap.put("ppid", c0739z.lj);
            }
            if (c0739z.lk != null) {
                m486a((HashMap) hashMap, c0739z.lk);
            }
        }
        if (c0739z.versionCode >= 3 && c0739z.lm != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, c0739z.lm);
        }
    }

    private static Integer m489j(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m490m(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }
}
