package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0916c;
import com.google.android.gms.internal.er;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C0411c.C0826a;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C0415g {
    private static Context PB;
    private static C0411c Rl;

    /* renamed from: com.google.android.gms.plus.internal.g.a */
    public static class C0414a extends Exception {
        public C0414a(String str) {
            super(str);
        }
    }

    private static C0411c m1208D(Context context) throws C0414a {
        er.m725f(context);
        if (Rl == null) {
            if (PB == null) {
                PB = GooglePlayServicesUtil.getRemoteContext(context);
                if (PB == null) {
                    throw new C0414a("Could not get remote context.");
                }
            }
            try {
                Rl = C0826a.az((IBinder) PB.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0414a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0414a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0414a("Could not access creator.");
            }
        }
        return Rl;
    }

    public static View m1209a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0916c.m2414b(C0415g.m1208D(context).m1191a(C0916c.m2415h(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }
}
