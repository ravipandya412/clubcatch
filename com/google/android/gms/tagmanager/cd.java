package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

abstract class cd extends aj {
    private static final String US;
    private static final String VQ;

    static {
        US = C0273b.ARG0.toString();
        VQ = C0273b.ARG1.toString();
    }

    public cd(String str) {
        super(str, US, VQ);
    }

    protected abstract boolean m2291a(C0945a c0945a, C0945a c0945a2, Map<String, C0945a> map);

    public boolean iy() {
        return true;
    }

    public C0945a m2292u(Map<String, C0945a> map) {
        for (C0945a c0945a : map.values()) {
            if (c0945a == di.ku()) {
                return di.m1360r(Boolean.valueOf(false));
            }
        }
        C0945a c0945a2 = (C0945a) map.get(US);
        C0945a c0945a3 = (C0945a) map.get(VQ);
        boolean a = (c0945a2 == null || c0945a3 == null) ? false : m2291a(c0945a2, c0945a3, map);
        return di.m1360r(Boolean.valueOf(a));
    }
}
