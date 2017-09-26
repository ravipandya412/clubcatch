package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0195a.C0592a;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.ei.C0332b;
import com.google.android.gms.internal.er;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.b */
final class C0596b implements GoogleApiClient {
    private int zA;
    private int zB;
    private int zC;
    private boolean zD;
    private int zE;
    private long zF;
    final Handler zG;
    private final Bundle zH;
    private final Map<C0191b<?>, C0190a> zI;
    private boolean zJ;
    final Set<C0198c> zK;
    final ConnectionCallbacks zL;
    private final C0332b zM;
    private final C0196a zm;
    private final Lock zv;
    private final Condition zw;
    private final ei zx;
    final Queue<C0198c<?>> zy;
    private ConnectionResult zz;

    /* renamed from: com.google.android.gms.common.api.b.a */
    interface C0196a {
        void m148b(C0198c c0198c);
    }

    /* renamed from: com.google.android.gms.common.api.b.b */
    class C0197b extends Handler {
        final /* synthetic */ C0596b zN;

        C0197b(C0596b c0596b, Looper looper) {
            this.zN = c0596b;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                this.zN.zv.lock();
                try {
                    if (!(this.zN.isConnected() || this.zN.isConnecting())) {
                        this.zN.connect();
                    }
                    this.zN.zv.unlock();
                } catch (Throwable th) {
                    this.zN.zv.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.c */
    interface C0198c<A extends C0190a> {
        void m149a(C0196a c0196a);

        void m150b(A a) throws DeadObjectException;

        C0191b<A> dp();

        int dr();

        void du();
    }

    /* renamed from: com.google.android.gms.common.api.b.1 */
    class C05931 implements C0196a {
        final /* synthetic */ C0596b zN;

        C05931(C0596b c0596b) {
            this.zN = c0596b;
        }

        public void m1519b(C0198c c0198c) {
            this.zN.zv.lock();
            try {
                this.zN.zK.remove(c0198c);
            } finally {
                this.zN.zv.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.2 */
    class C05942 implements ConnectionCallbacks {
        final /* synthetic */ C0596b zN;

        C05942(C0596b c0596b) {
            this.zN = c0596b;
        }

        public void onConnected(Bundle connectionHint) {
            this.zN.zv.lock();
            try {
                if (this.zN.zB == 1) {
                    if (connectionHint != null) {
                        this.zN.zH.putAll(connectionHint);
                    }
                    this.zN.dy();
                }
                this.zN.zv.unlock();
            } catch (Throwable th) {
                this.zN.zv.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.zN.zv.lock();
            try {
                this.zN.m1520G(cause);
                switch (cause) {
                    case SpinnerCompat.MODE_DROPDOWN /*1*/:
                        if (!this.zN.dA()) {
                            this.zN.zC = 2;
                            this.zN.zG.sendMessageDelayed(this.zN.zG.obtainMessage(1), this.zN.zF);
                            break;
                        }
                        this.zN.zv.unlock();
                        return;
                    case DetectedActivity.ON_FOOT /*2*/:
                        this.zN.connect();
                        break;
                }
                this.zN.zv.unlock();
            } catch (Throwable th) {
                this.zN.zv.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.3 */
    class C05953 implements C0332b {
        final /* synthetic */ C0596b zN;

        C05953(C0596b c0596b) {
            this.zN = c0596b;
        }

        public Bundle cY() {
            return null;
        }

        public boolean dC() {
            return this.zN.zJ;
        }

        public boolean isConnected() {
            return this.zN.isConnected();
        }
    }

    /* renamed from: com.google.android.gms.common.api.b.4 */
    class C08964 implements OnConnectionFailedListener {
        final /* synthetic */ C0596b zN;
        final /* synthetic */ C0191b zO;

        C08964(C0596b c0596b, C0191b c0191b) {
            this.zN = c0596b;
            this.zO = c0191b;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zN.zv.lock();
            try {
                if (this.zN.zz == null || this.zO.getPriority() < this.zN.zA) {
                    this.zN.zz = result;
                    this.zN.zA = this.zO.getPriority();
                }
                this.zN.dy();
            } finally {
                this.zN.zv.unlock();
            }
        }
    }

    public C0596b(Context context, Looper looper, ee eeVar, Map<Api, ApiOptions> map, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2) {
        this.zv = new ReentrantLock();
        this.zw = this.zv.newCondition();
        this.zy = new LinkedList();
        this.zB = 4;
        this.zC = 0;
        this.zD = false;
        this.zF = 5000;
        this.zH = new Bundle();
        this.zI = new HashMap();
        this.zK = new HashSet();
        this.zm = new C05931(this);
        this.zL = new C05942(this);
        this.zM = new C05953(this);
        this.zx = new ei(context, looper, this.zM);
        this.zG = new C0197b(this, looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.zx.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.zx.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            C0191b dp = api.dp();
            ApiOptions apiOptions = (ApiOptions) map.get(api);
            this.zI.put(dp, dp.m138b(context, looper, eeVar, apiOptions, this.zL, new C08964(this, dp)));
        }
    }

    private void m1520G(int i) {
        this.zv.lock();
        try {
            if (this.zB != 3) {
                if (i == -1) {
                    if (isConnecting()) {
                        Iterator it = this.zy.iterator();
                        while (it.hasNext()) {
                            if (((C0198c) it.next()).dr() != 1) {
                                it.remove();
                            }
                        }
                    } else {
                        this.zy.clear();
                    }
                    if (this.zz == null && !this.zy.isEmpty()) {
                        this.zD = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.zB = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.zz = null;
                    }
                    this.zw.signalAll();
                }
                for (C0198c du : this.zK) {
                    du.du();
                }
                this.zK.clear();
                this.zJ = false;
                for (C0190a c0190a : this.zI.values()) {
                    if (c0190a.isConnected()) {
                        c0190a.disconnect();
                    }
                }
                this.zJ = true;
                this.zB = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.zx.m670P(i);
                    }
                    this.zJ = false;
                }
            }
            this.zv.unlock();
        } finally {
            this.zv.unlock();
        }
    }

    private <A extends C0190a> void m1523a(C0198c<A> c0198c) throws DeadObjectException {
        this.zv.lock();
        try {
            er.m721a(isConnected(), "GoogleApiClient is not connected yet.");
            er.m721a(c0198c.dp() != null, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            if (c0198c instanceof Releasable) {
                this.zK.add(c0198c);
                c0198c.m149a(this.zm);
            }
            c0198c.m150b(m1535a(c0198c.dp()));
        } finally {
            this.zv.unlock();
        }
    }

    private boolean dA() {
        this.zv.lock();
        try {
            boolean z = this.zC != 0;
            this.zv.unlock();
            return z;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    private void dB() {
        this.zv.lock();
        try {
            this.zC = 0;
            this.zG.removeMessages(1);
        } finally {
            this.zv.unlock();
        }
    }

    private void dy() {
        this.zv.lock();
        try {
            this.zE--;
            if (this.zE == 0) {
                if (this.zz != null) {
                    this.zD = false;
                    m1520G(3);
                    if (dA()) {
                        this.zC--;
                    }
                    if (dA()) {
                        this.zG.sendMessageDelayed(this.zG.obtainMessage(1), this.zF);
                    } else {
                        this.zx.m671a(this.zz);
                    }
                    this.zJ = false;
                } else {
                    this.zB = 2;
                    dB();
                    this.zw.signalAll();
                    dz();
                    if (this.zD) {
                        this.zD = false;
                        m1520G(-1);
                    } else {
                        this.zx.m672b(this.zH.isEmpty() ? null : this.zH);
                    }
                }
            }
            this.zv.unlock();
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    private void dz() {
        er.m721a(isConnected(), "GoogleApiClient is not connected yet.");
        this.zv.lock();
        while (!this.zy.isEmpty()) {
            try {
                m1523a((C0198c) this.zy.remove());
            } catch (Throwable e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.zv.unlock();
            }
        }
        this.zv.unlock();
    }

    public <C extends C0190a> C m1535a(C0191b<C> c0191b) {
        Object obj = (C0190a) this.zI.get(c0191b);
        er.m723b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C0190a, T extends C0592a<? extends Result, A>> T m1536a(T t) {
        this.zv.lock();
        try {
            if (isConnected()) {
                m1537b((C0592a) t);
            } else {
                this.zy.add(t);
            }
            this.zv.unlock();
            return t;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public <A extends C0190a, T extends C0592a<? extends Result, A>> T m1537b(T t) {
        er.m721a(isConnected(), "GoogleApiClient is not connected yet.");
        dz();
        try {
            m1523a((C0198c) t);
        } catch (DeadObjectException e) {
            m1520G(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        er.m721a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zv.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.zw.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.yI;
                this.zv.unlock();
            } else if (this.zz != null) {
                connectionResult = this.zz;
                this.zv.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zv.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zv.unlock();
        }
        return connectionResult;
    }

    public void connect() {
        this.zv.lock();
        try {
            this.zD = false;
            if (isConnected() || isConnecting()) {
                this.zv.unlock();
                return;
            }
            this.zJ = true;
            this.zz = null;
            this.zB = 1;
            this.zH.clear();
            this.zE = this.zI.size();
            for (C0190a connect : this.zI.values()) {
                connect.connect();
            }
            this.zv.unlock();
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public void disconnect() {
        dB();
        m1520G(-1);
    }

    public boolean isConnected() {
        this.zv.lock();
        try {
            boolean z = this.zB == 2;
            this.zv.unlock();
            return z;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.zv.lock();
        try {
            if (this.zB != 1) {
                z = false;
            }
            this.zv.unlock();
            return z;
        } catch (Throwable th) {
            this.zv.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.zx.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.zx.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zx.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zx.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.zx.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zx.unregisterConnectionFailedListener(listener);
    }
}
