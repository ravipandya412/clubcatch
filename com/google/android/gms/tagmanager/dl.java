package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0306d.C0945a;
import com.pkr.clubcatch.C0519R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dl {
    private static by<C0945a> m1364a(by<C0945a> byVar) {
        try {
            return new by(di.m1360r(bO(di.m1349j((C0945a) byVar.getObject()))), byVar.jr());
        } catch (Throwable e) {
            bh.m1268c("Escape URI: unsupported encoding", e);
            return byVar;
        }
    }

    private static by<C0945a> m1365a(by<C0945a> byVar, int i) {
        if (m1367q((C0945a) byVar.getObject())) {
            switch (i) {
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    return m1364a(byVar);
                default:
                    bh.m1270t("Unsupported Value Escaping: " + i);
                    return byVar;
            }
        }
        bh.m1270t("Escaping can only be applied to strings.");
        return byVar;
    }

    static by<C0945a> m1366a(by<C0945a> byVar, int... iArr) {
        by a;
        for (int a2 : iArr) {
            a = m1365a(a, a2);
        }
        return a;
    }

    static String bO(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m1367q(C0945a c0945a) {
        return di.m1357o(c0945a) instanceof String;
    }
}
