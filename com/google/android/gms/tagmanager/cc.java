package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class cc extends aj {
    private static final String ID;
    private static final C0945a VP;

    static {
        ID = C0270a.PLATFORM.toString();
        VP = di.m1360r("Android");
    }

    public cc() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2290u(Map<String, C0945a> map) {
        return VP;
    }
}
