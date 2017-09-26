package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0573c.C0155b;
import com.google.android.gms.analytics.C0573c.C0156c;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.di;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.s */
class C0580s implements ag, C0155b, C0156c {
    private final Context mContext;
    private final GoogleAnalytics rA;
    private final Queue<C0176d> rB;
    private volatile int rC;
    private volatile Timer rD;
    private volatile Timer rE;
    private volatile Timer rF;
    private boolean rG;
    private boolean rH;
    private boolean rI;
    private C0161i rJ;
    private long rK;
    private C0157d rj;
    private final C0159f rk;
    private boolean rm;
    private volatile long rw;
    private volatile C0173a rx;
    private volatile C0153b ry;
    private C0157d rz;

    /* renamed from: com.google.android.gms.analytics.s.2 */
    class C01712 implements Runnable {
        final /* synthetic */ C0580s rL;

        C01712(C0580s c0580s) {
            this.rL = c0580s;
        }

        public void run() {
            this.rL.bJ();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.3 */
    static /* synthetic */ class C01723 {
        static final /* synthetic */ int[] rM;

        static {
            rM = new int[C0173a.values().length];
            try {
                rM[C0173a.CONNECTED_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rM[C0173a.CONNECTED_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rM[C0173a.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                rM[C0173a.PENDING_CONNECTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                rM[C0173a.PENDING_DISCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                rM[C0173a.DISCONNECTED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.a */
    private enum C0173a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.s.b */
    private class C0174b extends TimerTask {
        final /* synthetic */ C0580s rL;

        private C0174b(C0580s c0580s) {
            this.rL = c0580s;
        }

        public void run() {
            if (this.rL.rx == C0173a.CONNECTED_SERVICE && this.rL.rB.isEmpty() && this.rL.rw + this.rL.rK < this.rL.rJ.currentTimeMillis()) {
                aa.m50v("Disconnecting due to inactivity");
                this.rL.aD();
                return;
            }
            this.rL.rF.schedule(new C0174b(this.rL), this.rL.rK);
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.c */
    private class C0175c extends TimerTask {
        final /* synthetic */ C0580s rL;

        private C0175c(C0580s c0580s) {
            this.rL = c0580s;
        }

        public void run() {
            if (this.rL.rx == C0173a.CONNECTING) {
                this.rL.bL();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.d */
    private static class C0176d {
        private final Map<String, String> rV;
        private final long rW;
        private final String rX;
        private final List<di> rY;

        public C0176d(Map<String, String> map, long j, String str, List<di> list) {
            this.rV = map;
            this.rW = j;
            this.rX = str;
            this.rY = list;
        }

        public Map<String, String> bO() {
            return this.rV;
        }

        public long bP() {
            return this.rW;
        }

        public List<di> bQ() {
            return this.rY;
        }

        public String getPath() {
            return this.rX;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.rX);
            if (this.rV != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.rV.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.e */
    private class C0177e extends TimerTask {
        final /* synthetic */ C0580s rL;

        private C0177e(C0580s c0580s) {
            this.rL = c0580s;
        }

        public void run() {
            this.rL.bM();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s.1 */
    class C05791 implements C0161i {
        final /* synthetic */ C0580s rL;

        C05791(C0580s c0580s) {
            this.rL = c0580s;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    C0580s(Context context, C0159f c0159f) {
        this(context, c0159f, null, GoogleAnalytics.getInstance(context));
    }

    C0580s(Context context, C0159f c0159f, C0157d c0157d, GoogleAnalytics googleAnalytics) {
        this.rB = new ConcurrentLinkedQueue();
        this.rK = 300000;
        this.rz = c0157d;
        this.mContext = context;
        this.rk = c0159f;
        this.rA = googleAnalytics;
        this.rJ = new C05791(this);
        this.rC = 0;
        this.rx = C0173a.DISCONNECTED;
    }

    private Timer m1460a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void aD() {
        if (this.ry != null && this.rx == C0173a.CONNECTED_SERVICE) {
            this.rx = C0173a.PENDING_DISCONNECT;
            this.ry.disconnect();
        }
    }

    private void bH() {
        this.rD = m1460a(this.rD);
        this.rE = m1460a(this.rE);
        this.rF = m1460a(this.rF);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void bJ() {
        /*
        r8 = this;
        monitor-enter(r8);
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r3 = r8.rk;	 Catch:{ all -> 0x0074 }
        r3 = r3.getThread();	 Catch:{ all -> 0x0074 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0021;
    L_0x0011:
        r2 = r8.rk;	 Catch:{ all -> 0x0074 }
        r2 = r2.bs();	 Catch:{ all -> 0x0074 }
        r3 = new com.google.android.gms.analytics.s$2;	 Catch:{ all -> 0x0074 }
        r3.<init>(r8);	 Catch:{ all -> 0x0074 }
        r2.add(r3);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r8);
        return;
    L_0x0021:
        r2 = r8.rG;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x0028;
    L_0x0025:
        r8.bk();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r2 = com.google.android.gms.analytics.C0580s.C01723.rM;	 Catch:{ all -> 0x0074 }
        r3 = r8.rx;	 Catch:{ all -> 0x0074 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0074 }
        r2 = r2[r3];	 Catch:{ all -> 0x0074 }
        switch(r2) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r2 = r8.rB;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x0077;
    L_0x003e:
        r2 = r8.rB;	 Catch:{ all -> 0x0074 }
        r2 = r2.poll();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.C0580s.C0176d) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to store  ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m50v(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.rj;	 Catch:{ all -> 0x0074 }
        r3 = r7.bO();	 Catch:{ all -> 0x0074 }
        r4 = r7.bP();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.bQ();	 Catch:{ all -> 0x0074 }
        r2.m66a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r2 = move-exception;
        monitor-exit(r8);
        throw r2;
    L_0x0077:
        r2 = r8.rm;	 Catch:{ all -> 0x0074 }
        if (r2 == 0) goto L_0x001f;
    L_0x007b:
        r8.bK();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r2 = r8.rB;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00d0;
    L_0x0087:
        r2 = r8.rB;	 Catch:{ all -> 0x0074 }
        r2 = r2.peek();	 Catch:{ all -> 0x0074 }
        r0 = r2;
        r0 = (com.google.android.gms.analytics.C0580s.C0176d) r0;	 Catch:{ all -> 0x0074 }
        r7 = r0;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r2.<init>();	 Catch:{ all -> 0x0074 }
        r3 = "Sending hit to service   ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0074 }
        r2 = r2.append(r7);	 Catch:{ all -> 0x0074 }
        r2 = r2.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m50v(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.rA;	 Catch:{ all -> 0x0074 }
        r2 = r2.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x00ca;
    L_0x00af:
        r2 = r8.ry;	 Catch:{ all -> 0x0074 }
        r3 = r7.bO();	 Catch:{ all -> 0x0074 }
        r4 = r7.bP();	 Catch:{ all -> 0x0074 }
        r6 = r7.getPath();	 Catch:{ all -> 0x0074 }
        r7 = r7.bQ();	 Catch:{ all -> 0x0074 }
        r2.m64a(r3, r4, r6, r7);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r2 = r8.rB;	 Catch:{ all -> 0x0074 }
        r2.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r2 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.aa.m50v(r2);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r2 = r8.rJ;	 Catch:{ all -> 0x0074 }
        r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r8.rw = r2;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r2 = "Need to reconnect";
        com.google.android.gms.analytics.aa.m50v(r2);	 Catch:{ all -> 0x0074 }
        r2 = r8.rB;	 Catch:{ all -> 0x0074 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r2 != 0) goto L_0x001f;
    L_0x00e7:
        r8.bM();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.bJ():void");
    }

    private void bK() {
        this.rj.bp();
        this.rm = false;
    }

    private synchronized void bL() {
        if (this.rx != C0173a.CONNECTED_LOCAL) {
            bH();
            aa.m50v("falling back to local store");
            if (this.rz != null) {
                this.rj = this.rz;
            } else {
                C0578r bB = C0578r.bB();
                bB.m1457a(this.mContext, this.rk);
                this.rj = bB.bE();
            }
            this.rx = C0173a.CONNECTED_LOCAL;
            bJ();
        }
    }

    private synchronized void bM() {
        if (this.rI || this.ry == null || this.rx == C0173a.CONNECTED_LOCAL) {
            aa.m51w("client not initialized.");
            bL();
        } else {
            try {
                this.rC++;
                m1460a(this.rE);
                this.rx = C0173a.CONNECTING;
                this.rE = new Timer("Failed Connect");
                this.rE.schedule(new C0175c(), 3000);
                aa.m50v("connecting to Analytics service");
                this.ry.connect();
            } catch (SecurityException e) {
                aa.m51w("security exception on connectToService");
                bL();
            }
        }
    }

    private void bN() {
        this.rD = m1460a(this.rD);
        this.rD = new Timer("Service Reconnect");
        this.rD.schedule(new C0177e(), 5000);
    }

    public synchronized void m1471a(int i, Intent intent) {
        this.rx = C0173a.PENDING_CONNECTION;
        if (this.rC < 2) {
            aa.m51w("Service unavailable (code=" + i + "), will retry.");
            bN();
        } else {
            aa.m51w("Service unavailable (code=" + i + "), using local store.");
            bL();
        }
    }

    public void m1472b(Map<String, String> map, long j, String str, List<di> list) {
        aa.m50v("putHit called");
        this.rB.add(new C0176d(map, j, str, list));
        bJ();
    }

    public void bI() {
        if (this.ry == null) {
            this.ry = new C0573c(this.mContext, this, this);
            bM();
        }
    }

    public void bk() {
        aa.m50v("clearHits called");
        this.rB.clear();
        switch (C01723.rM[this.rx.ordinal()]) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                this.rj.m67i(0);
                this.rG = false;
            case DetectedActivity.ON_FOOT /*2*/:
                this.ry.bk();
                this.rG = false;
            default:
                this.rG = true;
        }
    }

    public void bp() {
        switch (C01723.rM[this.rx.ordinal()]) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                bK();
            case DetectedActivity.ON_FOOT /*2*/:
            default:
                this.rm = true;
        }
    }

    public synchronized void br() {
        if (!this.rI) {
            aa.m50v("setForceLocalDispatch called.");
            this.rI = true;
            switch (C01723.rM[this.rx.ordinal()]) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                case DetectedActivity.UNKNOWN /*4*/:
                case DetectedActivity.TILTING /*5*/:
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    aD();
                    break;
                case DetectedActivity.STILL /*3*/:
                    this.rH = true;
                    break;
                default:
                    break;
            }
        }
    }

    public synchronized void onConnected() {
        this.rE = m1460a(this.rE);
        this.rC = 0;
        aa.m50v("Connected to service");
        this.rx = C0173a.CONNECTED_SERVICE;
        if (this.rH) {
            aD();
            this.rH = false;
        } else {
            bJ();
            this.rF = m1460a(this.rF);
            this.rF = new Timer("disconnect check");
            this.rF.schedule(new C0174b(), this.rK);
        }
    }

    public synchronized void onDisconnected() {
        if (this.rx == C0173a.PENDING_DISCONNECT) {
            aa.m50v("Disconnected from service");
            bH();
            this.rx = C0173a.DISCONNECTED;
        } else {
            aa.m50v("Unexpected disconnect.");
            this.rx = C0173a.PENDING_CONNECTION;
            if (this.rC < 2) {
                bN();
            } else {
                bL();
            }
        }
    }
}
