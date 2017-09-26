package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class ah extends aj {
    private static final String ID;
    private final ct TO;

    static {
        ID = C0270a.EVENT.toString();
    }

    public ah(ct ctVar) {
        super(ID, new String[0]);
        this.TO = ctVar;
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2240u(Map<String, C0945a> map) {
        String jY = this.TO.jY();
        return jY == null ? di.ku() : di.m1360r(jY);
    }
}
