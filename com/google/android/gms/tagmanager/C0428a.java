package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import java.io.IOException;

/* renamed from: com.google.android.gms.tagmanager.a */
class C0428a {
    private static C0428a TA;
    private static Object qI;
    private volatile long Tv;
    private volatile long Tw;
    private volatile long Tx;
    private final fl Ty;
    private C0427a Tz;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread pI;
    private volatile Info qK;

    /* renamed from: com.google.android.gms.tagmanager.a.2 */
    class C04262 implements Runnable {
        final /* synthetic */ C0428a TB;

        C04262(C0428a c0428a) {
            this.TB = c0428a;
        }

        public void run() {
            this.TB.iv();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.a.a */
    public interface C0427a {
        Info ix();
    }

    /* renamed from: com.google.android.gms.tagmanager.a.1 */
    class C08381 implements C0427a {
        final /* synthetic */ C0428a TB;

        C08381(C0428a c0428a) {
            this.TB = c0428a;
        }

        public Info ix() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.TB.mContext);
            } catch (IllegalStateException e) {
                bh.m1273w("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m1273w("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m1273w("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m1273w("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m1273w("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    static {
        qI = new Object();
    }

    private C0428a(Context context) {
        this(context, null, fn.eI());
    }

    C0428a(Context context, C0427a c0427a, fl flVar) {
        this.Tv = 900000;
        this.Tw = 30000;
        this.mClosed = false;
        this.Tz = new C08381(this);
        this.Ty = flVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c0427a != null) {
            this.Tz = c0427a;
        }
        this.pI = new Thread(new C04262(this));
    }

    static C0428a m1242E(Context context) {
        if (TA == null) {
            synchronized (qI) {
                if (TA == null) {
                    TA = new C0428a(context);
                    TA.start();
                }
            }
        }
        return TA;
    }

    private void iv() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.qK = this.Tz.ix();
                Thread.sleep(this.Tv);
            } catch (InterruptedException e) {
                bh.m1271u("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void iw() {
        if (this.Ty.currentTimeMillis() - this.Tx >= this.Tw) {
            interrupt();
            this.Tx = this.Ty.currentTimeMillis();
        }
    }

    void interrupt() {
        this.pI.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        iw();
        return this.qK == null ? true : this.qK.isLimitAdTrackingEnabled();
    }

    public String iu() {
        iw();
        return this.qK == null ? null : this.qK.getId();
    }

    void start() {
        this.pI.start();
    }
}
