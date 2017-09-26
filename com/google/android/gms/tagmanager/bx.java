package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

abstract class bx extends cd {
    public bx(String str) {
        super(str);
    }

    protected boolean m2846a(C0945a c0945a, C0945a c0945a2, Map<String, C0945a> map) {
        dh k = di.m1350k(c0945a);
        dh k2 = di.m1350k(c0945a2);
        return (k == di.ks() || k2 == di.ks()) ? false : m2847a(k, k2, (Map) map);
    }

    protected abstract boolean m2847a(dh dhVar, dh dhVar2, Map<String, C0945a> map);
}
