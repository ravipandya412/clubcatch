package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C0853f extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0270a.APP_ID.toString();
    }

    public C0853f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2324u(Map<String, C0945a> map) {
        return di.m1360r(this.mContext.getPackageName());
    }
}
