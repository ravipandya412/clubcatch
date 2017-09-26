package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

abstract class dd extends cd {
    public dd(String str) {
        super(str);
    }

    protected boolean m2857a(C0945a c0945a, C0945a c0945a2, Map<String, C0945a> map) {
        String j = di.m1349j(c0945a);
        String j2 = di.m1349j(c0945a2);
        return (j == di.kt() || j2 == di.kt()) ? false : m2858a(j, j2, (Map) map);
    }

    protected abstract boolean m2858a(String str, String str2, Map<String, C0945a> map);
}
