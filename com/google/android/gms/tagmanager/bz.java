package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class bz extends aj {
    private static final String ID;

    static {
        ID = C0270a.OS_VERSION.toString();
    }

    public bz() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2270u(Map<String, C0945a> map) {
        return di.m1360r(VERSION.RELEASE);
    }
}
