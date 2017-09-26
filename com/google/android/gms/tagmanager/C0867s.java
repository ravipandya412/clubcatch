package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C0867s extends aj {
    private static final String ID;
    private static final String TF;
    private static final String Up;
    private final C0465a Uq;

    /* renamed from: com.google.android.gms.tagmanager.s.a */
    public interface C0465a {
        Object m1372b(String str, Map<String, Object> map);
    }

    static {
        ID = C0270a.FUNCTION_CALL.toString();
        Up = C0273b.FUNCTION_CALL_NAME.toString();
        TF = C0273b.ADDITIONAL_PARAMS.toString();
    }

    public C0867s(C0465a c0465a) {
        super(ID, Up);
        this.Uq = c0465a;
    }

    public boolean iy() {
        return false;
    }

    public C0945a m2340u(Map<String, C0945a> map) {
        String j = di.m1349j((C0945a) map.get(Up));
        Map hashMap = new HashMap();
        C0945a c0945a = (C0945a) map.get(TF);
        if (c0945a != null) {
            Object o = di.m1357o(c0945a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m1273w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return di.ku();
            }
        }
        try {
            return di.m1360r(this.Uq.m1372b(j, hashMap));
        } catch (Exception e) {
            bh.m1273w("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return di.ku();
        }
    }
}
