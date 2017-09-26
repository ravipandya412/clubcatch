package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class cv extends aj {
    private static final String ID;

    static {
        ID = C0270a.SDK_VERSION.toString();
    }

    public cv() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2302u(Map<String, C0945a> map) {
        return di.m1360r(Integer.valueOf(VERSION.SDK_INT));
    }
}
