package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C0841c extends aj {
    private static final String ID;
    private final C0428a TC;

    static {
        ID = C0270a.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public C0841c(Context context) {
        this(C0428a.m1242E(context));
    }

    C0841c(C0428a c0428a) {
        super(ID, new String[0]);
        this.TC = c0428a;
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2271u(Map<String, C0945a> map) {
        return di.m1360r(Boolean.valueOf(this.TC.isLimitAdTrackingEnabled()));
    }
}
