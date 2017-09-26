package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C0852e extends aj {
    private static final String ID;
    private static final String TD;
    private static final String TE;
    private final Context kL;

    static {
        ID = C0270a.ADWORDS_CLICK_REFERRER.toString();
        TD = C0273b.COMPONENT.toString();
        TE = C0273b.CONVERSION_ID.toString();
    }

    public C0852e(Context context) {
        super(ID, TE);
        this.kL = context;
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2323u(Map<String, C0945a> map) {
        C0945a c0945a = (C0945a) map.get(TE);
        if (c0945a == null) {
            return di.ku();
        }
        String j = di.m1349j(c0945a);
        c0945a = (C0945a) map.get(TD);
        String e = ay.m1260e(this.kL, j, c0945a != null ? di.m1349j(c0945a) : null);
        return e != null ? di.m1360r(e) : di.ku();
    }
}
