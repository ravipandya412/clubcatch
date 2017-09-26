package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C0839b extends aj {
    private static final String ID;
    private final C0428a TC;

    static {
        ID = C0270a.ADVERTISER_ID.toString();
    }

    public C0839b(Context context) {
        this(C0428a.m1242E(context));
    }

    C0839b(C0428a c0428a) {
        super(ID, new String[0]);
        this.TC = c0428a;
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2260u(Map<String, C0945a> map) {
        String iu = this.TC.iu();
        return iu == null ? di.ku() : di.m1360r(iu);
    }
}
