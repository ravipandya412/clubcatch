package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C0866p extends aj {
    private static final String ID;
    private final String Un;

    static {
        ID = C0270a.CONTAINER_VERSION.toString();
    }

    public C0866p(String str) {
        super(ID, new String[0]);
        this.Un = str;
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2339u(Map<String, C0945a> map) {
        return this.Un == null ? di.ku() : di.m1360r(this.Un);
    }
}
