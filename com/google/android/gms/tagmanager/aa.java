package com.google.android.gms.tagmanager;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.internal.C0270a;
import com.google.android.gms.internal.C0306d.C0945a;
import java.util.Map;

class aa extends aj {
    private static final String ID;

    static {
        ID = C0270a.DEVICE_NAME.toString();
    }

    public aa() {
        super(ID, new String[0]);
    }

    public boolean iy() {
        return true;
    }

    public C0945a m2238u(Map<String, C0945a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(EnvironmentCompat.MEDIA_UNKNOWN))) {
            obj = str + " " + obj;
        }
        return di.m1360r(obj);
    }
}
