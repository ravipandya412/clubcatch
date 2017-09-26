package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0254e;
import com.google.android.gms.dynamic.C0916c;
import com.google.android.gms.internal.ag.C0635a;
import com.google.android.gms.internal.ah.C0637a;

/* renamed from: com.google.android.gms.internal.y */
public final class C0738y extends C0254e<ah> {
    private static final C0738y ld;

    static {
        ld = new C0738y();
    }

    private C0738y() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ag m2126a(Context context, ab abVar, String str, be beVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            ag b = ld.m2127b(context, abVar, str, beVar);
            if (b != null) {
                return b;
            }
        }
        da.m566s("Using AdManager from the client jar.");
        return new C0993v(context, abVar, str, beVar, new db(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private ag m2127b(Context context, ab abVar, String str, be beVar) {
        try {
            return C0635a.m1644f(((ah) m363z(context)).m397a(C0916c.m2415h(context), abVar, str, beVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            da.m564b("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            da.m564b("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected ah m2128c(IBinder iBinder) {
        return C0637a.m1646g(iBinder);
    }

    protected /* synthetic */ Object m2129d(IBinder iBinder) {
        return m2128c(iBinder);
    }
}
