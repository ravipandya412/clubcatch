package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ei.C0332b;
import com.google.android.gms.internal.em.C0678a;
import com.google.android.gms.internal.en.C0680a;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;

public abstract class eh<T extends IInterface> implements GooglePlayServicesClient, C0190a, C0332b {
    public static final String[] BB;
    boolean BA;
    private T Bv;
    private final ArrayList<C0329b<?>> Bw;
    private C0330f Bx;
    private volatile int By;
    private final String[] Bz;
    private final Context mContext;
    final Handler mHandler;
    private final Looper zs;
    private final ei zx;

    /* renamed from: com.google.android.gms.internal.eh.a */
    final class C0328a extends Handler {
        final /* synthetic */ eh BC;

        public C0328a(eh ehVar, Looper looper) {
            this.BC = ehVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            C0329b c0329b;
            if (msg.what == 1 && !this.BC.isConnecting()) {
                c0329b = (C0329b) msg.obj;
                c0329b.cP();
                c0329b.unregister();
            } else if (msg.what == 3) {
                this.BC.zx.m671a(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                this.BC.By = 1;
                this.BC.Bv = null;
                this.BC.zx.m670P(((Integer) msg.obj).intValue());
            } else if (msg.what == 2 && !this.BC.isConnected()) {
                c0329b = (C0329b) msg.obj;
                c0329b.cP();
                c0329b.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((C0329b) msg.obj).ec();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.eh.b */
    protected abstract class C0329b<TListener> {
        final /* synthetic */ eh BC;
        private boolean BD;
        private TListener mListener;

        public C0329b(eh ehVar, TListener tListener) {
            this.BC = ehVar;
            this.mListener = tListener;
            this.BD = false;
        }

        protected abstract void m667a(TListener tListener);

        protected abstract void cP();

        public void ec() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.BD) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    m667a(obj);
                } catch (RuntimeException e) {
                    cP();
                    throw e;
                }
            }
            cP();
            synchronized (this) {
                this.BD = true;
            }
            unregister();
        }

        public void ed() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            ed();
            synchronized (this.BC.Bw) {
                this.BC.Bw.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.eh.f */
    final class C0330f implements ServiceConnection {
        final /* synthetic */ eh BC;

        C0330f(eh ehVar) {
            this.BC = ehVar;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            this.BC.m1782x(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.BC.mHandler.sendMessage(this.BC.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    /* renamed from: com.google.android.gms.internal.eh.c */
    public static final class C0674c implements ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks BE;

        public C0674c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.BE = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof C0674c ? this.BE.equals(((C0674c) other).BE) : this.BE.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.BE.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.BE.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.internal.eh.d */
    public abstract class C0675d<TListener> extends C0329b<TListener> {
        final /* synthetic */ eh BC;
        private final DataHolder zU;

        public C0675d(eh ehVar, TListener tListener, DataHolder dataHolder) {
            this.BC = ehVar;
            super(ehVar, tListener);
            this.zU = dataHolder;
        }

        protected final void m1764a(TListener tListener) {
            m1765a(tListener, this.zU);
        }

        protected abstract void m1765a(TListener tListener, DataHolder dataHolder);

        protected void cP() {
            if (this.zU != null) {
                this.zU.close();
            }
        }

        public /* bridge */ /* synthetic */ void ec() {
            super.ec();
        }

        public /* bridge */ /* synthetic */ void ed() {
            super.ed();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.eh.h */
    protected final class C0676h extends C0329b<Boolean> {
        final /* synthetic */ eh BC;
        public final Bundle BH;
        public final IBinder BI;
        public final int statusCode;

        public C0676h(eh ehVar, int i, IBinder iBinder, Bundle bundle) {
            this.BC = ehVar;
            super(ehVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.BI = iBinder;
            this.BH = bundle;
        }

        protected /* synthetic */ void m1766a(Object obj) {
            m1767b((Boolean) obj);
        }

        protected void m1767b(Boolean bool) {
            if (bool == null) {
                this.BC.By = 1;
                return;
            }
            switch (this.statusCode) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    try {
                        if (this.BC.aG().equals(this.BI.getInterfaceDescriptor())) {
                            this.BC.Bv = this.BC.m1781p(this.BI);
                            if (this.BC.Bv != null) {
                                this.BC.By = 3;
                                this.BC.zx.bo();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    ej.m682y(this.BC.mContext).m684b(this.BC.aF(), this.BC.Bx);
                    this.BC.Bx = null;
                    this.BC.By = 1;
                    this.BC.Bv = null;
                    this.BC.zx.m671a(new ConnectionResult(8, null));
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    this.BC.By = 1;
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.BH != null ? (PendingIntent) this.BH.getParcelable("pendingIntent") : null;
                    if (this.BC.Bx != null) {
                        ej.m682y(this.BC.mContext).m684b(this.BC.aF(), this.BC.Bx);
                        this.BC.Bx = null;
                    }
                    this.BC.By = 1;
                    this.BC.Bv = null;
                    this.BC.zx.m671a(new ConnectionResult(this.statusCode, pendingIntent));
            }
        }

        protected void cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.eh.e */
    public static final class C0951e extends C0678a {
        private eh BF;

        public C0951e(eh ehVar) {
            this.BF = ehVar;
        }

        public void m2596b(int i, IBinder iBinder, Bundle bundle) {
            er.m723b((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.BF);
            this.BF.m1777a(i, iBinder, bundle);
            this.BF = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.eh.g */
    public static final class C0952g implements OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener BG;

        public C0952g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.BG = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof C0952g ? this.BG.equals(((C0952g) other).BG) : this.BG.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.BG.onConnectionFailed(result);
        }
    }

    static {
        BB = new String[]{"service_esmobile", "service_googleme"};
    }

    protected eh(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.Bw = new ArrayList();
        this.By = 1;
        this.BA = false;
        this.mContext = (Context) er.m725f(context);
        this.zs = (Looper) er.m723b((Object) looper, (Object) "Looper must not be null");
        this.zx = new ei(context, looper, this);
        this.mHandler = new C0328a(this, looper);
        m1780b(strArr);
        this.Bz = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) er.m725f(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) er.m725f(onConnectionFailedListener));
    }

    protected eh(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C0674c(connectionCallbacks), new C0952g(onConnectionFailedListener), strArr);
    }

    public void m1776O(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected void m1777a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0676h(this, i, iBinder, bundle)));
    }

    public final void m1778a(C0329b<?> c0329b) {
        synchronized (this.Bw) {
            this.Bw.add(c0329b);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c0329b));
    }

    protected abstract void m1779a(en enVar, C0951e c0951e) throws RemoteException;

    protected abstract String aF();

    protected abstract String aG();

    protected void m1780b(String... strArr) {
    }

    protected final void bm() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public Bundle cY() {
        return null;
    }

    public void connect() {
        this.BA = true;
        this.By = 2;
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            this.By = 1;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.Bx != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.Bv = null;
            ej.m682y(this.mContext).m684b(aF(), this.Bx);
        }
        this.Bx = new C0330f(this);
        if (!ej.m682y(this.mContext).m683a(aF(), this.Bx)) {
            Log.e("GmsClient", "unable to connect to service: " + aF());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    public boolean dC() {
        return this.BA;
    }

    public void disconnect() {
        this.BA = false;
        synchronized (this.Bw) {
            int size = this.Bw.size();
            for (int i = 0; i < size; i++) {
                ((C0329b) this.Bw.get(i)).ed();
            }
            this.Bw.clear();
        }
        this.By = 1;
        this.Bv = null;
        if (this.Bx != null) {
            ej.m682y(this.mContext).m684b(aF(), this.Bx);
            this.Bx = null;
        }
    }

    public final String[] ea() {
        return this.Bz;
    }

    protected final T eb() {
        bm();
        return this.Bv;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zs;
    }

    public boolean isConnected() {
        return this.By == 3;
    }

    public boolean isConnecting() {
        return this.By == 2;
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.zx.isConnectionCallbacksRegistered(new C0674c(listener));
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.zx.isConnectionFailedListenerRegistered(listener);
    }

    protected abstract T m1781p(IBinder iBinder);

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.zx.registerConnectionCallbacks(new C0674c(listener));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zx.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.zx.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zx.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.zx.unregisterConnectionCallbacks(new C0674c(listener));
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.zx.unregisterConnectionFailedListener(listener);
    }

    protected final void m1782x(IBinder iBinder) {
        try {
            m1779a(C0680a.m1809z(iBinder), new C0951e(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }
}
