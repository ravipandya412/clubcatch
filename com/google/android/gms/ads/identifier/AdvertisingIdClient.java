package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0189a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0363t;
import com.google.android.gms.internal.C0363t.C0737a;
import com.google.android.gms.internal.er;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final String kF;
        private final boolean kG;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.kF = advertisingId;
            this.kG = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.kF;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kG;
        }
    }

    static Info m24a(Context context, C0189a c0189a) throws IOException {
        try {
            C0363t b = C0737a.m2125b(c0189a.dm());
            Info info = new Info(b.getId(), b.m1106a(true));
            try {
                context.unbindService(c0189a);
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e);
            }
            return info;
        } catch (Throwable e2) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
            throw new IOException("Remote exception");
        } catch (InterruptedException e3) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            try {
                context.unbindService(c0189a);
            } catch (Throwable e4) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e4);
            }
        }
    }

    private static C0189a m25g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m133s(context);
                Object c0189a = new C0189a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c0189a, 1)) {
                    return c0189a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        er.ad("Calling this from your main thread can lead to deadlock");
        return m24a(context, m25g(context));
    }
}
