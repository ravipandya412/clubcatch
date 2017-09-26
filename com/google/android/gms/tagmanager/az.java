package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID;
    private static final String US;
    private static final String Vo;
    private static final String Vp;
    private static final String Vq;

    /* renamed from: com.google.android.gms.tagmanager.az.1 */
    static /* synthetic */ class C04301 {
        static final /* synthetic */ int[] Vr;

        static {
            Vr = new int[C0431a.values().length];
            try {
                Vr[C0431a.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Vr[C0431a.BACKSLASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Vr[C0431a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.az.a */
    private enum C0431a {
        NONE,
        URL,
        BACKSLASH
    }

    static {
        ID = C0270a.JOINER.toString();
        US = C0273b.ARG0.toString();
        Vo = C0273b.ITEM_SEPARATOR.toString();
        Vp = C0273b.KEY_VALUE_SEPARATOR.toString();
        Vq = C0273b.ESCAPE.toString();
    }

    public az() {
        super(ID, US);
    }

    private String m2256a(String str, C0431a c0431a, Set<Character> set) {
        switch (C04301.Vr[c0431a.ordinal()]) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                try {
                    return dl.bO(str);
                } catch (Throwable e) {
                    bh.m1268c("Joiner: unsupported encoding", e);
                    return str;
                }
            case DetectedActivity.ON_FOOT /*2*/:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void m2257a(StringBuilder stringBuilder, String str, C0431a c0431a, Set<Character> set) {
        stringBuilder.append(m2256a(str, c0431a, set));
    }

    private void m2258a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2259u(Map<String, C0945a> map) {
        C0945a c0945a = (C0945a) map.get(US);
        if (c0945a == null) {
            return di.ku();
        }
        C0431a c0431a;
        Set set;
        C0945a c0945a2 = (C0945a) map.get(Vo);
        String j = c0945a2 != null ? di.m1349j(c0945a2) : "";
        c0945a2 = (C0945a) map.get(Vp);
        String j2 = c0945a2 != null ? di.m1349j(c0945a2) : "=";
        C0431a c0431a2 = C0431a.NONE;
        c0945a2 = (C0945a) map.get(Vq);
        if (c0945a2 != null) {
            String j3 = di.m1349j(c0945a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c0431a = C0431a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c0431a = C0431a.BACKSLASH;
                set = new HashSet();
                m2258a(set, j);
                m2258a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m1270t("Joiner: unsupported escape type: " + j3);
                return di.ku();
            }
        }
        set = null;
        c0431a = c0431a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c0945a.type) {
            case DetectedActivity.ON_FOOT /*2*/:
                Object obj = 1;
                C0945a[] c0945aArr = c0945a.fZ;
                int length = c0945aArr.length;
                int i = 0;
                while (i < length) {
                    C0945a c0945a3 = c0945aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m2257a(stringBuilder, di.m1349j(c0945a3), c0431a, set);
                    i++;
                    obj = null;
                }
                break;
            case DetectedActivity.STILL /*3*/:
                for (int i2 = 0; i2 < c0945a.ga.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = di.m1349j(c0945a.ga[i2]);
                    String j5 = di.m1349j(c0945a.gb[i2]);
                    m2257a(stringBuilder, j4, c0431a, set);
                    stringBuilder.append(j2);
                    m2257a(stringBuilder, j5, c0431a, set);
                }
                break;
            default:
                m2257a(stringBuilder, di.m1349j(c0945a), c0431a, set);
                break;
        }
        return di.m1360r(stringBuilder.toString());
    }
}
