package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class cf extends aj {
    private static final String ID;
    private static final String Wa;
    private static final String Wb;

    static {
        ID = C0270a.RANDOM.toString();
        Wa = C0273b.MIN.toString();
        Wb = C0273b.MAX.toString();
    }

    public cf() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2293u(Map<String, C0945a> map) {
        double doubleValue;
        double d;
        C0945a c0945a = (C0945a) map.get(Wa);
        C0945a c0945a2 = (C0945a) map.get(Wb);
        if (!(c0945a == null || c0945a == di.ku() || c0945a2 == null || c0945a2 == di.ku())) {
            dh k = di.m1350k(c0945a);
            dh k2 = di.m1350k(c0945a2);
            if (!(k == di.ks() || k2 == di.ks())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return di.m1360r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return di.m1360r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
