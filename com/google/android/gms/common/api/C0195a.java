package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C0190a;
import com.google.android.gms.common.api.Api.C0191b;
import com.google.android.gms.common.api.C0596b.C0196a;
import com.google.android.gms.common.api.C0596b.C0198c;
import com.google.android.gms.common.api.PendingResult.C0192a;
import com.google.android.gms.internal.er;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.a */
public class C0195a {

    /* renamed from: com.google.android.gms.common.api.a.b */
    public static class C0193b<R extends Result> extends Handler {
        public C0193b() {
            this(Looper.getMainLooper());
        }

        public C0193b(Looper looper) {
            super(looper);
        }

        public void m144a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void m145a(C0592a<R, ?> c0592a, long j) {
            sendMessageDelayed(obtainMessage(2, c0592a), j);
        }

        protected void m146b(ResultCallback<R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        public void dw() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    Pair pair = (Pair) msg.obj;
                    m146b((ResultCallback) pair.first, (Result) pair.second);
                case DetectedActivity.ON_FOOT /*2*/:
                    C0592a c0592a = (C0592a) msg.obj;
                    c0592a.m1514a(c0592a.m1518d(Status.zS));
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a.c */
    public interface C0194c<R> {
        void m147b(R r);
    }

    /* renamed from: com.google.android.gms.common.api.a.a */
    public static abstract class C0592a<R extends Result, A extends C0190a> implements PendingResult<R>, C0194c<R>, C0198c<A> {
        private final C0191b<A> zc;
        private final Object zd;
        private C0193b<R> ze;
        private final CountDownLatch zf;
        private final ArrayList<C0192a> zg;
        private ResultCallback<R> zh;
        private volatile R zi;
        private volatile boolean zj;
        private boolean zk;
        private boolean zl;
        private C0196a zm;

        protected C0592a() {
            this((C0191b) null);
        }

        protected C0592a(C0191b<A> c0191b) {
            this.zd = new Object();
            this.zf = new CountDownLatch(1);
            this.zg = new ArrayList();
            this.zc = c0191b;
        }

        private void m1512a(RemoteException remoteException) {
            m1514a(m1518d(new Status(8, remoteException.getLocalizedMessage(), null)));
        }

        private R ds() {
            R r;
            synchronized (this.zd) {
                er.m721a(!this.zj, "Result has already been consumed.");
                er.m721a(isReady(), "Result is not ready.");
                r = this.zi;
                dt();
            }
            return r;
        }

        private void dv() {
            if (this.zi != null && (this instanceof Releasable)) {
                try {
                    ((Releasable) this).release();
                } catch (Throwable e) {
                    Log.w("GoogleApi", "Unable to release " + this, e);
                }
            }
        }

        protected abstract void m1513a(A a) throws RemoteException;

        public final void m1514a(R r) {
            boolean z = true;
            synchronized (this.zd) {
                if (this.zl) {
                    if (r instanceof Releasable) {
                        ((Releasable) r).release();
                    }
                    return;
                }
                er.m721a(!isReady(), "Results have already been set");
                if (this.zj) {
                    z = false;
                }
                er.m721a(z, "Result has already been consumed");
                this.zi = r;
                if (this.zk) {
                    dv();
                    return;
                }
                this.zf.countDown();
                Status status = this.zi.getStatus();
                if (this.zh != null) {
                    this.ze.dw();
                    this.ze.m144a(this.zh, ds());
                }
                Iterator it = this.zg.iterator();
                while (it.hasNext()) {
                    ((C0192a) it.next()).m142k(status);
                }
                this.zg.clear();
            }
        }

        public void m1515a(C0196a c0196a) {
            this.zm = c0196a;
        }

        public final R await() {
            boolean z = false;
            er.m721a(!this.zj, "Results has already been consumed");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            er.m721a(z, "await must not be called on the UI thread");
            try {
                this.zf.await();
            } catch (InterruptedException e) {
                synchronized (this.zd) {
                }
                m1514a(m1518d(Status.zR));
                this.zl = true;
            }
            er.m721a(isReady(), "Result is not ready.");
            return ds();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = false;
            er.m721a(!this.zj, "Result has already been consumed.");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            er.m721a(z, "await must not be called on the UI thread");
            try {
                if (!this.zf.await(time, units)) {
                    synchronized (this.zd) {
                        m1514a(m1518d(Status.zS));
                        this.zl = true;
                    }
                }
            } catch (InterruptedException e) {
                synchronized (this.zd) {
                }
                m1514a(m1518d(Status.zR));
                this.zl = true;
            }
            er.m721a(isReady(), "Result is not ready.");
            return ds();
        }

        public final void m1516b(A a) throws DeadObjectException {
            this.ze = new C0193b(a.getLooper());
            try {
                m1513a((C0190a) a);
            } catch (RemoteException e) {
                m1512a(e);
                throw e;
            } catch (RemoteException e2) {
                m1512a(e2);
            }
        }

        public /* synthetic */ void m1517b(Object obj) {
            m1514a((Result) obj);
        }

        protected abstract R m1518d(Status status);

        public final C0191b<A> dp() {
            return this.zc;
        }

        public int dr() {
            return 0;
        }

        void dt() {
            this.zj = true;
            this.zi = null;
            if (this.zm != null) {
                this.zm.m148b(this);
            }
        }

        public void du() {
            dv();
            this.zk = true;
        }

        public final boolean isReady() {
            return this.zf.getCount() == 0;
        }

        public final void setResultCallback(ResultCallback<R> callback) {
            er.m721a(!this.zj, "Result has already been consumed.");
            synchronized (this.zd) {
                if (isReady()) {
                    this.ze.m144a((ResultCallback) callback, ds());
                } else {
                    this.zh = callback;
                }
            }
        }

        public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
            er.m721a(!this.zj, "Result has already been consumed.");
            synchronized (this.zd) {
                if (isReady()) {
                    this.ze.m144a((ResultCallback) callback, ds());
                } else {
                    this.zh = callback;
                    this.ze.m145a(this, units.toMillis(time));
                }
            }
        }
    }
}
