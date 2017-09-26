package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0183u.C0182a;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.analytics.r */
class C0578r extends af {
    private static final Object ri;
    private static C0578r ru;
    private Context mContext;
    private Handler mHandler;
    private C0157d rj;
    private volatile C0159f rk;
    private int rl;
    private boolean rm;
    private boolean rn;
    private String ro;
    private boolean rp;
    private boolean rq;
    private C0158e rr;
    private C0169q rs;
    private boolean rt;

    /* renamed from: com.google.android.gms.analytics.r.2 */
    class C01702 implements Callback {
        final /* synthetic */ C0578r rv;

        C01702(C0578r c0578r) {
            this.rv = c0578r;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && C0578r.ri.equals(msg.obj)) {
                C0183u.bR().m85r(true);
                this.rv.dispatchLocalHits();
                C0183u.bR().m85r(false);
                if (this.rv.rl > 0 && !this.rv.rt) {
                    this.rv.mHandler.sendMessageDelayed(this.rv.mHandler.obtainMessage(1, C0578r.ri), (long) (this.rv.rl * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.gms.analytics.r.1 */
    class C05771 implements C0158e {
        final /* synthetic */ C0578r rv;

        C05771(C0578r c0578r) {
            this.rv = c0578r;
        }

        public void m1452p(boolean z) {
            this.rv.m1458a(z, this.rv.rp);
        }
    }

    static {
        ri = new Object();
    }

    private C0578r() {
        this.rl = 1800;
        this.rm = true;
        this.rp = true;
        this.rq = true;
        this.rr = new C05771(this);
        this.rt = false;
    }

    public static C0578r bB() {
        if (ru == null) {
            ru = new C0578r();
        }
        return ru;
    }

    private void bC() {
        this.rs = new C0169q(this);
        this.rs.m83o(this.mContext);
    }

    private void bD() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C01702(this));
        if (this.rl > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, ri), (long) (this.rl * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
        }
    }

    synchronized void m1457a(Context context, C0159f c0159f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.rk == null) {
                this.rk = c0159f;
                if (this.rm) {
                    dispatchLocalHits();
                    this.rm = false;
                }
                if (this.rn) {
                    br();
                    this.rn = false;
                }
            }
        }
    }

    synchronized void m1458a(boolean z, boolean z2) {
        if (!(this.rt == z && this.rp == z2)) {
            if (z || !z2) {
                if (this.rl > 0) {
                    this.mHandler.removeMessages(1, ri);
                }
            }
            if (!z && z2 && this.rl > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, ri), (long) (this.rl * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            aa.m50v(append.append(str).toString());
            this.rt = z;
            this.rp = z2;
        }
    }

    synchronized C0157d bE() {
        if (this.rj == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.rj = new ac(this.rr, this.mContext);
            if (this.ro != null) {
                this.rj.bq().m76A(this.ro);
                this.ro = null;
            }
        }
        if (this.mHandler == null) {
            bD();
        }
        if (this.rs == null && this.rq) {
            bC();
        }
        return this.rj;
    }

    synchronized void bF() {
        if (!this.rt && this.rp && this.rl > 0) {
            this.mHandler.removeMessages(1, ri);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, ri));
        }
    }

    void br() {
        if (this.rk == null) {
            aa.m50v("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.rn = true;
            return;
        }
        C0183u.bR().m84a(C0182a.SET_FORCE_LOCAL_DISPATCH);
        this.rk.br();
    }

    synchronized void dispatchLocalHits() {
        if (this.rk == null) {
            aa.m50v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.rm = true;
        } else {
            C0183u.bR().m84a(C0182a.DISPATCH);
            this.rk.bp();
        }
    }

    synchronized void m1459q(boolean z) {
        m1458a(this.rt, z);
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            aa.m50v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.rl = dispatchPeriodInSeconds;
        } else {
            C0183u.bR().m84a(C0182a.SET_DISPATCH_PERIOD);
            if (!this.rt && this.rp && this.rl > 0) {
                this.mHandler.removeMessages(1, ri);
            }
            this.rl = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.rt && this.rp) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, ri), (long) (dispatchPeriodInSeconds * GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE));
            }
        }
    }
}
