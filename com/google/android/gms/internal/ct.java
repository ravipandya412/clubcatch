package com.google.android.gms.internal;

public abstract class ct {
    private final Runnable kW;
    private volatile Thread pI;

    /* renamed from: com.google.android.gms.internal.ct.1 */
    class C03011 implements Runnable {
        final /* synthetic */ ct pJ;

        C03011(ct ctVar) {
            this.pJ = ctVar;
        }

        public final void run() {
            this.pJ.pI = Thread.currentThread();
            this.pJ.aB();
        }
    }

    public ct() {
        this.kW = new C03011(this);
    }

    public abstract void aB();

    public final void cancel() {
        onStop();
        if (this.pI != null) {
            this.pI.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        cu.execute(this.kW);
    }
}
