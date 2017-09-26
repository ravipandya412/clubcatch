package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C0855h extends aj {
    private static final String ID;
    private final Context mContext;

    static {
        ID = C0270a.APP_VERSION.toString();
    }

    public C0855h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2326u(Map<String, C0945a> map) {
        try {
            return di.m1360r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m1270t("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return di.ku();
        }
    }
}
