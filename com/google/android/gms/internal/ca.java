package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.cb.C0943a;
import com.google.android.gms.internal.cb.C0944b;

public final class ca {

    /* renamed from: com.google.android.gms.internal.ca.a */
    public interface C0297a {
        void m472a(cf cfVar);
    }

    public static ct m473a(Context context, cd cdVar, C0297a c0297a) {
        return cdVar.kN.pX ? m474b(context, cdVar, c0297a) : m475c(context, cdVar, c0297a);
    }

    private static ct m474b(Context context, cd cdVar, C0297a c0297a) {
        da.m566s("Fetching ad response from local ad request service.");
        ct c0943a = new C0943a(context, cdVar, c0297a);
        c0943a.start();
        return c0943a;
    }

    private static ct m475c(Context context, cd cdVar, C0297a c0297a) {
        da.m566s("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C0944b(context, cdVar, c0297a);
        }
        da.m570w("Failed to connect to remote ad request service.");
        return null;
    }
}
