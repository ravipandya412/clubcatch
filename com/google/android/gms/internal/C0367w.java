package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.w */
public final class C0367w {
    private final Runnable kW;
    private C0739z kX;
    private boolean kY;

    /* renamed from: com.google.android.gms.internal.w.1 */
    class C03661 implements Runnable {
        private final WeakReference<C0993v> kZ;
        final /* synthetic */ C0993v la;
        final /* synthetic */ C0367w lb;

        C03661(C0367w c0367w, C0993v c0993v) {
            this.lb = c0367w;
            this.la = c0993v;
            this.kZ = new WeakReference(this.la);
        }

        public void run() {
            this.lb.kY = false;
            C0993v c0993v = (C0993v) this.kZ.get();
            if (c0993v != null) {
                c0993v.m2810b(this.lb.kX);
            }
        }
    }

    public C0367w(C0993v c0993v) {
        this.kY = false;
        this.kW = new C03661(this, c0993v);
    }

    public void m1113a(C0739z c0739z, long j) {
        if (this.kY) {
            da.m570w("An ad refresh is already scheduled.");
            return;
        }
        da.m568u("Scheduling ad refresh " + j + " milliseconds from now.");
        this.kX = c0739z;
        this.kY = true;
        cz.pT.postDelayed(this.kW, j);
    }

    public void cancel() {
        cz.pT.removeCallbacks(this.kW);
    }

    public void m1114d(C0739z c0739z) {
        m1113a(c0739z, 60000);
    }
}
