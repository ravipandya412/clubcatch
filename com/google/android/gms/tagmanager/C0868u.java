package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C0868u extends aj {
    private static final String ID;
    private static final String NAME;
    private static final String UC;
    private final DataLayer TN;

    static {
        ID = C0270a.CUSTOM_VAR.toString();
        NAME = C0273b.NAME.toString();
        UC = C0273b.DEFAULT_VALUE.toString();
    }

    public C0868u(DataLayer dataLayer) {
        super(ID, NAME);
        this.TN = dataLayer;
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2341u(Map<String, C0945a> map) {
        Object obj = this.TN.get(di.m1349j((C0945a) map.get(NAME)));
        if (obj != null) {
            return di.m1360r(obj);
        }
        C0945a c0945a = (C0945a) map.get(UC);
        return c0945a != null ? c0945a : di.ku();
    }
}
