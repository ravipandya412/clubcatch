package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C0858m extends aj {
    private static final String ID;
    private static final String VALUE;

    static {
        ID = C0270a.CONSTANT.toString();
        VALUE = C0273b.VALUE.toString();
    }

    public C0858m() {
        super(ID, VALUE);
    }

    public static String iB() {
        return ID;
    }

    public static String iC() {
        return VALUE;
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2327u(Map<String, C0945a> map) {
        return (C0945a) map.get(VALUE);
    }
}
