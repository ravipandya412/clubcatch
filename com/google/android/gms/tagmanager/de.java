package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class de extends aj {
    private static final String ID;

    static {
        ID = C0270a.TIME.toString();
    }

    public de() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2320u(Map<String, C0945a> map) {
        return di.m1360r(Long.valueOf(System.currentTimeMillis()));
    }
}
