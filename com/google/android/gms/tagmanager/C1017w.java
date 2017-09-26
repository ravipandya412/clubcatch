package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C1017w extends dg {
    private static final String ID;
    private static final String UN;
    private static final String VALUE;
    private final DataLayer TN;

    static {
        ID = C0270a.DATA_LAYER_WRITE.toString();
        VALUE = C0273b.VALUE.toString();
        UN = C0273b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    }

    public C1017w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.TN = dataLayer;
    }

    private void m2885a(C0945a c0945a) {
        if (c0945a != null && c0945a != di.ko()) {
            String j = di.m1349j(c0945a);
            if (j != di.kt()) {
                this.TN.bg(j);
            }
        }
    }

    private void m2886b(C0945a c0945a) {
        if (c0945a != null && c0945a != di.ko()) {
            Object o = di.m1357o(c0945a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.TN.push((Map) o2);
                    }
                }
            }
        }
    }

    public void m2887w(Map<String, C0945a> map) {
        m2886b((C0945a) map.get(VALUE));
        m2885a((C0945a) map.get(UN));
    }
}
