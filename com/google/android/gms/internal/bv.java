package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0254e;
import com.google.android.gms.dynamic.C0916c;
import com.google.android.gms.internal.bw.C0655a;
import com.google.android.gms.internal.bx.C0657a;

public final class bv extends C0254e<bx> {
    private static final bv nL;

    /* renamed from: com.google.android.gms.internal.bv.a */
    private static final class C0290a extends Exception {
        public C0290a(String str) {
            super(str);
        }
    }

    static {
        nL = new bv();
    }

    private bv() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static bw m1686a(Activity activity) {
        try {
            if (!m1687b(activity)) {
                return nL.m1688c(activity);
            }
            da.m566s("Using AdOverlay from the client jar.");
            return new bo(activity);
        } catch (C0290a e) {
            da.m570w(e.getMessage());
            return null;
        }
    }

    private static boolean m1687b(Activity activity) throws C0290a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0290a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private bw m1688c(Activity activity) {
        try {
            return C0655a.m1691m(((bx) m363z(activity)).m469a(C0916c.m2415h(activity)));
        } catch (Throwable e) {
            da.m564b("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            da.m564b("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object m1689d(IBinder iBinder) {
        return m1690l(iBinder);
    }

    protected bx m1690l(IBinder iBinder) {
        return C0657a.m1693n(iBinder);
    }
}
