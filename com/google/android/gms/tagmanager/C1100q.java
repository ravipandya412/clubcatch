package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.q */
class C1100q extends dd {
    private static final String ID;

    static {
        ID = C0270a.CONTAINS.toString();
    }

    public C1100q() {
        super(ID);
    }

    protected boolean m3108a(String str, String str2, Map<String, C0945a> map) {
        return str.contains(str2);
    }
}
