package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class al extends bx {
    private static final String ID;

    static {
        ID = C0270a.GREATER_EQUALS.toString();
    }

    public al() {
        super(ID);
    }

    protected boolean m3102a(dh dhVar, dh dhVar2, Map<String, C0945a> map) {
        return dhVar.m1348a(dhVar2) >= 0;
    }
}
