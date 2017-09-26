package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0296c.C0942j;
import com.google.android.gms.tagmanager.C1016o.C0864e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp implements C0864e {
    private final String TM;
    private String Ui;
    private bg<C0942j> Wi;
    private C0464r Wj;
    private final ScheduledExecutorService Wl;
    private final C0437a Wm;
    private ScheduledFuture<?> Wn;
    private boolean mClosed;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cp.a */
    interface C0437a {
        co m1295a(C0464r c0464r);
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.b */
    interface C0438b {
        ScheduledExecutorService jB();
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.1 */
    class C08431 implements C0438b {
        final /* synthetic */ cp Wo;

        C08431(cp cpVar) {
            this.Wo = cpVar;
        }

        public ScheduledExecutorService jB() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cp.2 */
    class C08442 implements C0437a {
        final /* synthetic */ cp Wo;

        C08442(cp cpVar) {
            this.Wo = cpVar;
        }

        public co m2296a(C0464r c0464r) {
            return new co(this.Wo.mContext, this.Wo.TM, c0464r);
        }
    }

    public cp(Context context, String str, C0464r c0464r) {
        this(context, str, c0464r, null, null);
    }

    cp(Context context, String str, C0464r c0464r, C0438b c0438b, C0437a c0437a) {
        this.Wj = c0464r;
        this.mContext = context;
        this.TM = str;
        if (c0438b == null) {
            c0438b = new C08431(this);
        }
        this.Wl = c0438b.jB();
        if (c0437a == null) {
            this.Wm = new C08442(this);
        } else {
            this.Wm = c0437a;
        }
    }

    private co bv(String str) {
        co a = this.Wm.m1295a(this.Wj);
        a.m1294a(this.Wi);
        a.bf(this.Ui);
        a.bu(str);
        return a;
    }

    private synchronized void jA() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void m2850a(bg<C0942j> bgVar) {
        jA();
        this.Wi = bgVar;
    }

    public synchronized void bf(String str) {
        jA();
        this.Ui = str;
    }

    public synchronized void m2851d(long j, String str) {
        bh.m1272v("loadAfterDelay: containerId=" + this.TM + " delay=" + j);
        jA();
        if (this.Wi == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.Wn != null) {
            this.Wn.cancel(false);
        }
        this.Wn = this.Wl.schedule(bv(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        jA();
        if (this.Wn != null) {
            this.Wn.cancel(false);
        }
        this.Wl.shutdown();
        this.mClosed = true;
    }
}
