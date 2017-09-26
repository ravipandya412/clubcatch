package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0916c;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.internal.C0373c.C0767a;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.q */
public class C0387q {
    private static Context PB;
    private static C0373c PC;

    public static C0373c m1139A(Context context) throws GooglePlayServicesNotAvailableException {
        er.m725f(context);
        if (PC != null) {
            return PC;
        }
        C0387q.m1140B(context);
        PC = C0387q.m1141C(context);
        try {
            PC.m1125a(C0916c.m2415h(C0387q.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return PC;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void m1140B(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static C0373c m1141C(Context context) {
        if (!C0387q.ha()) {
            return C0767a.m2148U((IBinder) C0387q.m1142a(C0387q.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
        Log.i(C0387q.class.getSimpleName(), "Making Creator statically");
        return (C0373c) C0387q.m1143c(C0387q.hb());
    }

    private static <T> T m1142a(ClassLoader classLoader, String str) {
        try {
            return C0387q.m1143c(((ClassLoader) er.m725f(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static <T> T m1143c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (PB == null) {
            if (C0387q.ha()) {
                PB = context;
            } else {
                PB = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return PB;
    }

    private static boolean ha() {
        return false;
    }

    private static Class<?> hb() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
