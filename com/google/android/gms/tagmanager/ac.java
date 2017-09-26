package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class ac extends aj {
    private static final String ID;
    private static final String US;
    private static final String UT;
    private static final String UU;
    private static final String UV;

    static {
        ID = C0270a.ENCODE.toString();
        US = C0273b.ARG0.toString();
        UT = C0273b.NO_PADDING.toString();
        UU = C0273b.INPUT_FORMAT.toString();
        UV = C0273b.OUTPUT_FORMAT.toString();
    }

    public ac() {
        super(ID, US);
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2239u(Map<String, C0945a> map) {
        C0945a c0945a = (C0945a) map.get(US);
        if (c0945a == null || c0945a == di.ku()) {
            return di.ku();
        }
        String j = di.m1349j(c0945a);
        c0945a = (C0945a) map.get(UU);
        String j2 = c0945a == null ? "text" : di.m1349j(c0945a);
        c0945a = (C0945a) map.get(UV);
        String j3 = c0945a == null ? "base16" : di.m1349j(c0945a);
        c0945a = (C0945a) map.get(UT);
        int i = (c0945a == null || !di.m1355n(c0945a).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C0457j.aX(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m1270t("Encode: unknown input format: " + j2);
                return di.ku();
            }
            if ("base16".equals(j3)) {
                d = C0457j.m1368d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m1270t("Encode: unknown output format: " + j3);
                return di.ku();
            }
            return di.m1360r(d);
        } catch (IllegalArgumentException e) {
            bh.m1270t("Encode: invalid input:");
            return di.ku();
        }
    }
}
