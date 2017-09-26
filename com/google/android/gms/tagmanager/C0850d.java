package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.tagmanager.DataLayer.C0420b;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.d */
class C0850d implements C0420b {
    private final Context kL;

    public C0850d(Context context) {
        this.kL = context;
    }

    public void m2312v(Map<String, Object> map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            obj = map.get("gtm");
            if (obj != null && (obj instanceof Map)) {
                obj = ((Map) obj).get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        ay.m1261e(this.kL, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
