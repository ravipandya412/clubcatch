package com.google.android.gms.tagmanager;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.C0306d.C0945a;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di {
    private static final Object XI;
    private static Long XJ;
    private static Double XK;
    private static dh XL;
    private static String XM;
    private static Boolean XN;
    private static List<Object> XO;
    private static Map<Object, Object> XP;
    private static C0945a XQ;

    static {
        XI = null;
        XJ = new Long(0);
        XK = new Double(0.0d);
        XL = dh.m1347v(0);
        XM = new String("");
        XN = new Boolean(false);
        XO = new ArrayList(0);
        XP = new HashMap();
        XQ = m1360r(XM);
    }

    public static C0945a bI(String str) {
        C0945a c0945a = new C0945a();
        c0945a.type = 5;
        c0945a.gd = str;
        return c0945a;
    }

    private static dh bJ(String str) {
        try {
            return dh.bH(str);
        } catch (NumberFormatException e) {
            bh.m1270t("Failed to convert '" + str + "' to a number.");
            return XL;
        }
    }

    private static Long bK(String str) {
        dh bJ = bJ(str);
        return bJ == XL ? XJ : Long.valueOf(bJ.longValue());
    }

    private static Double bL(String str) {
        dh bJ = bJ(str);
        return bJ == XL ? XK : Double.valueOf(bJ.doubleValue());
    }

    private static Boolean bM(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : XN;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.m1270t("getDouble received non-Number");
        return 0.0d;
    }

    public static String m1349j(C0945a c0945a) {
        return m1353m(m1357o(c0945a));
    }

    public static dh m1350k(C0945a c0945a) {
        return m1354n(m1357o(c0945a));
    }

    public static Object ko() {
        return XI;
    }

    public static Long kp() {
        return XJ;
    }

    public static Double kq() {
        return XK;
    }

    public static Boolean kr() {
        return XN;
    }

    public static dh ks() {
        return XL;
    }

    public static String kt() {
        return XM;
    }

    public static C0945a ku() {
        return XQ;
    }

    public static Long m1351l(C0945a c0945a) {
        return m1356o(m1357o(c0945a));
    }

    public static Double m1352m(C0945a c0945a) {
        return m1358p(m1357o(c0945a));
    }

    public static String m1353m(Object obj) {
        return obj == null ? XM : obj.toString();
    }

    public static dh m1354n(Object obj) {
        return obj instanceof dh ? (dh) obj : m1362t(obj) ? dh.m1347v(m1363u(obj)) : m1361s(obj) ? dh.m1346a(Double.valueOf(getDouble(obj))) : bJ(m1353m(obj));
    }

    public static Boolean m1355n(C0945a c0945a) {
        return m1359q(m1357o(c0945a));
    }

    public static Long m1356o(Object obj) {
        return m1362t(obj) ? Long.valueOf(m1363u(obj)) : bK(m1353m(obj));
    }

    public static Object m1357o(C0945a c0945a) {
        int i = 0;
        if (c0945a == null) {
            return XI;
        }
        C0945a[] c0945aArr;
        int length;
        switch (c0945a.type) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return c0945a.fY;
            case DetectedActivity.ON_FOOT /*2*/:
                ArrayList arrayList = new ArrayList(c0945a.fZ.length);
                c0945aArr = c0945a.fZ;
                length = c0945aArr.length;
                while (i < length) {
                    Object o = m1357o(c0945aArr[i]);
                    if (o == XI) {
                        return XI;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case DetectedActivity.STILL /*3*/:
                if (c0945a.ga.length != c0945a.gb.length) {
                    bh.m1270t("Converting an invalid value to object: " + c0945a.toString());
                    return XI;
                }
                Map hashMap = new HashMap(c0945a.gb.length);
                while (i < c0945a.ga.length) {
                    Object o2 = m1357o(c0945a.ga[i]);
                    Object o3 = m1357o(c0945a.gb[i]);
                    if (o2 == XI || o3 == XI) {
                        return XI;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case DetectedActivity.UNKNOWN /*4*/:
                bh.m1270t("Trying to convert a macro reference to object");
                return XI;
            case DetectedActivity.TILTING /*5*/:
                bh.m1270t("Trying to convert a function id to object");
                return XI;
            case Participant.STATUS_UNRESPONSIVE /*6*/:
                return Long.valueOf(c0945a.ge);
            case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                c0945aArr = c0945a.gg;
                length = c0945aArr.length;
                while (i < length) {
                    String j = m1349j(c0945aArr[i]);
                    if (j == XM) {
                        return XI;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                return Boolean.valueOf(c0945a.gf);
            default:
                bh.m1270t("Failed to convert a value of type: " + c0945a.type);
                return XI;
        }
    }

    public static Double m1358p(Object obj) {
        return m1361s(obj) ? Double.valueOf(getDouble(obj)) : bL(m1353m(obj));
    }

    public static Boolean m1359q(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : bM(m1353m(obj));
    }

    public static C0945a m1360r(Object obj) {
        boolean z = false;
        C0945a c0945a = new C0945a();
        if (obj instanceof C0945a) {
            return (C0945a) obj;
        }
        if (obj instanceof String) {
            c0945a.type = 1;
            c0945a.fY = (String) obj;
        } else if (obj instanceof List) {
            c0945a.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object r : list) {
                C0945a r2 = m1360r(r);
                if (r2 == XQ) {
                    return XQ;
                }
                r0 = r1 || r2.gi;
                r5.add(r2);
                r1 = r0;
            }
            c0945a.fZ = (C0945a[]) r5.toArray(new C0945a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c0945a.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C0945a r3 = m1360r(entry.getKey());
                C0945a r4 = m1360r(entry.getValue());
                if (r3 == XQ || r4 == XQ) {
                    return XQ;
                }
                r0 = r1 || r3.gi || r4.gi;
                r5.add(r3);
                arrayList.add(r4);
                r1 = r0;
            }
            c0945a.ga = (C0945a[]) r5.toArray(new C0945a[0]);
            c0945a.gb = (C0945a[]) arrayList.toArray(new C0945a[0]);
            z = r1;
        } else if (m1361s(obj)) {
            c0945a.type = 1;
            c0945a.fY = obj.toString();
        } else if (m1362t(obj)) {
            c0945a.type = 6;
            c0945a.ge = m1363u(obj);
        } else if (obj instanceof Boolean) {
            c0945a.type = 8;
            c0945a.gf = ((Boolean) obj).booleanValue();
        } else {
            bh.m1270t("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return XQ;
        }
        c0945a.gi = z;
        return c0945a;
    }

    private static boolean m1361s(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dh) && ((dh) obj).kj());
    }

    private static boolean m1362t(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dh) && ((dh) obj).kk());
    }

    private static long m1363u(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.m1270t("getInt64 received non-Number");
        return 0;
    }
}
