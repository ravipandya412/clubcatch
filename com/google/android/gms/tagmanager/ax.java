package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class ax extends aj {
    private static final String ID;
    private static final String TD;
    private final Context kL;

    static {
        ID = C0270a.INSTALL_REFERRER.toString();
        TD = C0273b.COMPONENT.toString();
    }

    public ax(Context context) {
        super(ID, new String[0]);
        this.kL = context;
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2255u(Map<String, C0945a> map) {
        String d = ay.m1259d(this.kL, ((C0945a) map.get(TD)) != null ? di.m1349j((C0945a) map.get(TD)) : null);
        return d != null ? di.m1360r(d) : di.ku();
    }
}
