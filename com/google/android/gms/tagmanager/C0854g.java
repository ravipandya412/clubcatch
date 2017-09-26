package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C0854g extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0270a.APP_NAME.toString();
    }

    public C0854g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2325u(Map<String, C0945a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return di.m1360r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m1268c("App name is not found.", e);
            return di.ku();
        }
    }
}
