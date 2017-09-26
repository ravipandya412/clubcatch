package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0296c.C0935c;
import com.google.android.gms.internal.C0296c.C0936d;
import com.google.android.gms.internal.C0296c.C0941i;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class ai {
    private static void m1246a(DataLayer dataLayer, C0936d c0936d) {
        for (C0945a j : c0936d.fd) {
            dataLayer.bg(di.m1349j(j));
        }
    }

    public static void m1247a(DataLayer dataLayer, C0941i c0941i) {
        if (c0941i.fT == null) {
            bh.m1273w("supplemental missing experimentSupplemental");
            return;
        }
        m1246a(dataLayer, c0941i.fT);
        m1248b(dataLayer, c0941i.fT);
        m1250c(dataLayer, c0941i.fT);
    }

    private static void m1248b(DataLayer dataLayer, C0936d c0936d) {
        for (C0945a c : c0936d.fc) {
            Map c2 = m1249c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map<String, Object> m1249c(C0945a c0945a) {
        Object o = di.m1357o(c0945a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m1273w("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void m1250c(DataLayer dataLayer, C0936d c0936d) {
        for (C0935c c0935c : c0936d.fe) {
            if (c0935c.eX == null) {
                bh.m1273w("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c0935c.eX);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c0935c.eY;
                long j2 = c0935c.eZ;
                if (!c0935c.fa || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m1273w("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.bg(c0935c.eX);
                Map b = dataLayer.m1234b(c0935c.eX, obj);
                if (c0935c.fb > 0) {
                    if (b.containsKey("gtm")) {
                        Object obj2 = b.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c0935c.fb));
                        } else {
                            bh.m1273w("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        b.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c0935c.fb)));
                    }
                }
                dataLayer.push(b);
            }
        }
    }
}
