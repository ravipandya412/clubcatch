package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C0872z extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0270a.DEVICE_ID.toString();
    }

    public C0872z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    protected String m2365G(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2366u(Map<String, C0945a> map) {
        String G = m2365G(this.mContext);
        return G == null ? di.ku() : di.m1360r(G);
    }
}
