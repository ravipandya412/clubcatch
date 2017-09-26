package com.google.android.gms.internal;

import android.content.Context;

public final class aw {
    private final bf kH;
    private final Context mContext;
    private final cd mf;
    private final Object mg;
    private final ay mh;
    private boolean mi;
    private bb mj;

    /* renamed from: com.google.android.gms.internal.aw.1 */
    class C02721 implements Runnable {
        final /* synthetic */ bc mk;
        final /* synthetic */ aw ml;

        C02721(aw awVar, bc bcVar) {
            this.ml = awVar;
            this.mk = bcVar;
        }

        public void run() {
            try {
                this.mk.mN.destroy();
            } catch (Throwable e) {
                da.m564b("Could not destroy mediation adapter.", e);
            }
        }
    }

    public aw(Context context, cd cdVar, bf bfVar, ay ayVar) {
        this.mg = new Object();
        this.mi = false;
        this.mContext = context;
        this.mf = cdVar;
        this.kH = bfVar;
        this.mh = ayVar;
    }

    public bc m428a(long j, long j2) {
        da.m566s("Starting mediation.");
        for (ax axVar : this.mh.mr) {
            da.m568u("Trying mediation network: " + axVar.mm);
            for (String str : axVar.mn) {
                synchronized (this.mg) {
                    if (this.mi) {
                        bc bcVar = new bc(-1);
                        return bcVar;
                    }
                    this.mj = new bb(this.mContext, str, this.kH, this.mh, axVar, this.mf.oc, this.mf.kQ, this.mf.kN);
                    bcVar = this.mj.m1671b(j, j2);
                    if (bcVar.mL == 0) {
                        da.m566s("Adapter succeeded.");
                        return bcVar;
                    } else if (bcVar.mN != null) {
                        cz.pT.post(new C02721(this, bcVar));
                    }
                }
            }
        }
        return new bc(1);
    }

    public void cancel() {
        synchronized (this.mg) {
            this.mi = true;
            if (this.mj != null) {
                this.mj.cancel();
            }
        }
    }
}
