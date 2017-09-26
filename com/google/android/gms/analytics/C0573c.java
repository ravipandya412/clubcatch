package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dj;
import com.google.android.gms.internal.dj.C0663a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0573c implements C0153b {
    private Context mContext;
    private ServiceConnection qM;
    private C0155b qN;
    private C0156c qO;
    private dj qP;

    /* renamed from: com.google.android.gms.analytics.c.a */
    final class C0154a implements ServiceConnection {
        final /* synthetic */ C0573c qQ;

        C0154a(C0573c c0573c) {
            this.qQ = c0573c;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            aa.m50v("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    aa.m50v("bound to service");
                    this.qQ.qP = C0663a.m1713r(binder);
                    this.qQ.bn();
                    return;
                }
            } catch (RemoteException e) {
            }
            this.qQ.mContext.unbindService(this);
            this.qQ.qM = null;
            this.qQ.qO.m65a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            aa.m50v("service disconnected: " + component);
            this.qQ.qM = null;
            this.qQ.qN.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c.b */
    public interface C0155b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c.c */
    public interface C0156c {
        void m65a(int i, Intent intent);
    }

    public C0573c(Context context, C0155b c0155b, C0156c c0156c) {
        this.mContext = context;
        if (c0155b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.qN = c0155b;
        if (c0156c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.qO = c0156c;
    }

    private dj bl() {
        bm();
        return this.qP;
    }

    private void bn() {
        bo();
    }

    private void bo() {
        this.qN.onConnected();
    }

    public void m1442a(Map<String, String> map, long j, String str, List<di> list) {
        try {
            bl().m599a(map, j, str, list);
        } catch (RemoteException e) {
            aa.m48t("sendHit failed: " + e);
        }
    }

    public void bk() {
        try {
            bl().bk();
        } catch (RemoteException e) {
            aa.m48t("clear hits failed: " + e);
        }
    }

    protected void bm() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.qM != null) {
            aa.m48t("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.qM = new C0154a(this);
        boolean bindService = this.mContext.bindService(intent, this.qM, 129);
        aa.m50v("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.qM = null;
            this.qO.m65a(1, null);
        }
    }

    public void disconnect() {
        this.qP = null;
        if (this.qM != null) {
            try {
                this.mContext.unbindService(this.qM);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.qM = null;
            this.qN.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.qP != null;
    }
}
