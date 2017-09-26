package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.analytics.a */
class C0570a implements C0165m {
    private static Object qI;
    private static C0570a qJ;
    private Context mContext;
    private Info qK;
    private long qL;

    static {
        qI = new Object();
    }

    private C0570a(Context context) {
        this.mContext = context;
    }

    private Info bj() {
        Info info = null;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (IllegalStateException e) {
            aa.m51w("IllegalStateException getting Ad Id Info");
        } catch (GooglePlayServicesRepairableException e2) {
            aa.m51w("GooglePlayServicesRepairableException getting Ad Id Info");
        } catch (IOException e3) {
            aa.m51w("IOException getting Ad Id Info");
        } catch (GooglePlayServicesNotAvailableException e4) {
            aa.m51w("GooglePlayServicesNotAvailableException getting Ad Id Info");
        } catch (Exception e5) {
            aa.m51w("Unknown exception. Could not get the ad Id.");
        }
        return info;
    }

    public static C0165m m1407m(Context context) {
        if (qJ == null) {
            synchronized (qI) {
                if (qJ == null) {
                    qJ = new C0570a(context);
                }
            }
        }
        return qJ;
    }

    public String getValue(String field) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.qL > 1000) {
            this.qK = bj();
            this.qL = currentTimeMillis;
        }
        if (this.qK != null) {
            if ("&adid".equals(field)) {
                return this.qK.getId();
            }
            if ("&ate".equals(field)) {
                return this.qK.isLimitAdTrackingEnabled() ? "1" : "0";
            }
        }
        return null;
    }
}
