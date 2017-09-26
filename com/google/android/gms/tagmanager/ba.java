package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0273b;
import com.google.android.gms.internal.C0306d.C0945a;
import com.google.android.gms.tagmanager.cr.C0442a;
import com.google.android.gms.tagmanager.cr.C0444c;
import com.google.android.gms.tagmanager.cr.C0445d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static C0444c br(String str) throws JSONException {
        C0945a k = m1263k(new JSONObject(str));
        C0445d jI = C0444c.jI();
        for (int i = 0; i < k.ga.length; i++) {
            jI.m1299a(C0442a.jE().m1297b(C0273b.INSTANCE_NAME.toString(), k.ga[i]).m1297b(C0273b.FUNCTION.toString(), di.bI(C0858m.iB())).m1297b(C0858m.iC(), k.gb[i]).jH());
        }
        return jI.jL();
    }

    private static C0945a m1263k(Object obj) throws JSONException {
        return di.m1360r(m1264l(obj));
    }

    static Object m1264l(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m1264l(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
