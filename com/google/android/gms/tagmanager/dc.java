package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class dc extends dd {
    private static final String ID;

    static {
        ID = C0270a.STARTS_WITH.toString();
    }

    public dc() {
        super(ID);
    }

    protected boolean m3107a(String str, String str2, Map<String, C0945a> map) {
        return str.startsWith(str2);
    }
}
