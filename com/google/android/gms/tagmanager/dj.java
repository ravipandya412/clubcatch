package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dj extends dg {
    private static final String ID;
    private static final String XR;
    private static final String XS;
    private static final String XT;
    private static final String XU;
    private static final String XV;
    private static final String XW;
    private static Map<String, String> XX;
    private static Map<String, String> XY;
    private final DataLayer TN;
    private final Set<String> XZ;
    private final df Ya;

    static {
        ID = C0270a.UNIVERSAL_ANALYTICS.toString();
        XR = C0273b.ACCOUNT.toString();
        XS = C0273b.ANALYTICS_PASS_THROUGH.toString();
        XT = C0273b.ANALYTICS_FIELDS.toString();
        XU = C0273b.TRACK_TRANSACTION.toString();
        XV = C0273b.TRANSACTION_DATALAYER_MAP.toString();
        XW = C0273b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    }

    public dj(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new df(context));
    }

    dj(Context context, DataLayer dataLayer, df dfVar) {
        super(ID, new String[0]);
        this.TN = dataLayer;
        this.Ya = dfVar;
        this.XZ = new HashSet();
        this.XZ.add("");
        this.XZ.add("0");
        this.XZ.add("false");
    }

    private Map<String, String> m2859E(Map<String, C0945a> map) {
        C0945a c0945a = (C0945a) map.get(XV);
        if (c0945a != null) {
            return m2863c(c0945a);
        }
        if (XX == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            XX = hashMap;
        }
        return XX;
    }

    private Map<String, String> m2860F(Map<String, C0945a> map) {
        C0945a c0945a = (C0945a) map.get(XW);
        if (c0945a != null) {
            return m2863c(c0945a);
        }
        if (XY == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            XY = hashMap;
        }
        return XY;
    }

    private void m2861a(Tracker tracker, Map<String, C0945a> map) {
        String bN = bN("transactionId");
        if (bN == null) {
            bh.m1270t("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = m2865p((C0945a) map.get(XT));
            p.put("&t", "transaction");
            for (Entry entry : m2859E(map).entrySet()) {
                m2862b(p, (String) entry.getValue(), bN((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> kv = kv();
            if (kv != null) {
                for (Map map2 : kv) {
                    if (map2.get("name") == null) {
                        bh.m1270t("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = m2865p((C0945a) map.get(XT));
                    p2.put("&t", "item");
                    p2.put("&ti", bN);
                    for (Entry entry2 : m2860F(map).entrySet()) {
                        m2862b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bh.m1268c("Unable to send transaction", e);
        }
    }

    private void m2862b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private String bN(String str) {
        Object obj = this.TN.get(str);
        return obj == null ? null : obj.toString();
    }

    private Map<String, String> m2863c(C0945a c0945a) {
        Object o = di.m1357o(c0945a);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private boolean m2864d(Map<String, C0945a> map, String str) {
        C0945a c0945a = (C0945a) map.get(str);
        return c0945a == null ? false : di.m1355n(c0945a).booleanValue();
    }

    private List<Map<String, String>> kv() {
        Object obj = this.TN.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private Map<String, String> m2865p(C0945a c0945a) {
        if (c0945a == null) {
            return new HashMap();
        }
        Map<String, String> c = m2863c(c0945a);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.XZ.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    public void m2866w(Map<String, C0945a> map) {
        Tracker bF = this.Ya.bF("_GTM_DEFAULT_TRACKER_");
        if (m2864d(map, XS)) {
            bF.send(m2865p((C0945a) map.get(XT)));
        } else if (m2864d(map, XU)) {
            m2861a(bF, map);
        } else {
            bh.m1273w("Ignoring unknown tag.");
        }
    }
}
