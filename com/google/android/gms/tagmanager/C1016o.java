package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0296c.C0938f;
import com.google.android.gms.internal.C0296c.C0942j;
import com.google.android.gms.internal.fl;
import com.google.android.gms.internal.fn;
import com.google.android.gms.internal.jd.C0991a;
import com.google.android.gms.tagmanager.C1015n.C0461a;
import com.google.android.gms.tagmanager.bg.C0433a;
import com.google.android.gms.tagmanager.ce.C0436a;
import com.google.android.gms.tagmanager.cr.C0444c;

/* renamed from: com.google.android.gms.tagmanager.o */
class C1016o extends ca<ContainerHolder> {
    private final String TM;
    private long TR;
    private final TagManager TY;
    private final fl Ty;
    private final C0863d Ub;
    private final cg Uc;
    private final int Ud;
    private C0865f Ue;
    private volatile C1015n Uf;
    private volatile boolean Ug;
    private C0942j Uh;
    private String Ui;
    private C0864e Uj;
    private C0463a Uk;
    private final Context mContext;
    private final Looper zs;

    /* renamed from: com.google.android.gms.tagmanager.o.a */
    interface C0463a {
        boolean m1371b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.1 */
    class C08591 implements C0461a {
        final /* synthetic */ C1016o Ul;

        C08591(C1016o c1016o) {
            this.Ul = c1016o;
        }

        public void bc(String str) {
            this.Ul.bc(str);
        }

        public String iF() {
            return this.Ul.iF();
        }

        public void iH() {
            bh.m1273w("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.2 */
    class C08602 implements C0463a {
        final /* synthetic */ C1016o Ul;
        final /* synthetic */ boolean Um;

        C08602(C1016o c1016o, boolean z) {
            this.Ul = c1016o;
            this.Um = z;
        }

        public boolean m2328b(Container container) {
            return this.Um ? container.getLastRefreshTime() + 43200000 >= this.Ul.Ty.currentTimeMillis() : !container.isDefault();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.b */
    private class C0861b implements bg<C0991a> {
        final /* synthetic */ C1016o Ul;

        private C0861b(C1016o c1016o) {
            this.Ul = c1016o;
        }

        public void m2329a(C0991a c0991a) {
            C0942j c0942j;
            if (c0991a.Yc != null) {
                c0942j = c0991a.Yc;
            } else {
                C0938f c0938f = c0991a.fV;
                c0942j = new C0942j();
                c0942j.fV = c0938f;
                c0942j.fU = null;
                c0942j.fW = c0938f.fr;
            }
            this.Ul.m2871a(c0942j, c0991a.Yb, true);
        }

        public void m2330a(C0433a c0433a) {
            if (!this.Ul.Ug) {
                this.Ul.m2881s(0);
            }
        }

        public /* synthetic */ void m2331i(Object obj) {
            m2329a((C0991a) obj);
        }

        public void iM() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.c */
    private class C0862c implements bg<C0942j> {
        final /* synthetic */ C1016o Ul;

        private C0862c(C1016o c1016o) {
            this.Ul = c1016o;
        }

        public void m2332a(C0433a c0433a) {
            if (this.Ul.Uf != null) {
                this.Ul.m2272a(this.Ul.Uf);
            } else {
                this.Ul.m2272a(this.Ul.m2883O(Status.zS));
            }
            this.Ul.m2881s(3600000);
        }

        public void m2333b(C0942j c0942j) {
            synchronized (this.Ul) {
                if (c0942j.fV == null) {
                    if (this.Ul.Uh.fV == null) {
                        bh.m1270t("Current resource is null; network resource is also null");
                        this.Ul.m2881s(3600000);
                        return;
                    }
                    c0942j.fV = this.Ul.Uh.fV;
                }
                this.Ul.m2871a(c0942j, this.Ul.Ty.currentTimeMillis(), false);
                bh.m1272v("setting refresh time to current time: " + this.Ul.TR);
                if (!this.Ul.iL()) {
                    this.Ul.m2870a(c0942j);
                }
            }
        }

        public /* synthetic */ void m2334i(Object obj) {
            m2333b((C0942j) obj);
        }

        public void iM() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.d */
    private class C0863d implements C0461a {
        final /* synthetic */ C1016o Ul;

        private C0863d(C1016o c1016o) {
            this.Ul = c1016o;
        }

        public void bc(String str) {
            this.Ul.bc(str);
        }

        public String iF() {
            return this.Ul.iF();
        }

        public void iH() {
            if (this.Ul.Uc.cl()) {
                this.Ul.m2881s(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o.e */
    interface C0864e extends Releasable {
        void m2335a(bg<C0942j> bgVar);

        void bf(String str);

        void m2336d(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o.f */
    interface C0865f extends Releasable {
        void m2337a(bg<C0991a> bgVar);

        void m2338b(C0991a c0991a);

        C0444c bP(int i);

        void iN();
    }

    C1016o(Context context, TagManager tagManager, Looper looper, String str, int i, C0865f c0865f, C0864e c0864e, fl flVar, cg cgVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.TY = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zs = looper;
        this.TM = str;
        this.Ud = i;
        this.Ue = c0865f;
        this.Uj = c0864e;
        this.Ub = new C0863d();
        this.Uh = new C0942j();
        this.Ty = flVar;
        this.Uc = cgVar;
        if (iL()) {
            bc(ce.ju().jw());
        }
    }

    public C1016o(Context context, TagManager tagManager, Looper looper, String str, int i, C0464r c0464r) {
        this(context, tagManager, looper, str, i, new cq(context, str), new cp(context, str, c0464r), fn.eI(), new bf(30, 900000, 5000, "refreshing", fn.eI()));
    }

    private synchronized void m2870a(C0942j c0942j) {
        if (this.Ue != null) {
            C0991a c0991a = new C0991a();
            c0991a.Yb = this.TR;
            c0991a.fV = new C0938f();
            c0991a.Yc = c0942j;
            this.Ue.m2338b(c0991a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m2871a(com.google.android.gms.internal.C0296c.C0942j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.Ug;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.Uf;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.Uh = r9;	 Catch:{ all -> 0x006a }
        r8.TR = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.TR;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.Ty;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.m2881s(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.TY;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.TM;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.Uf;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.TY;	 Catch:{ all -> 0x006a }
        r3 = r8.zs;	 Catch:{ all -> 0x006a }
        r4 = r8.Ub;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.Uf = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.Uk;	 Catch:{ all -> 0x006a }
        r0 = r1.m1371b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.Uf;	 Catch:{ all -> 0x006a }
        r8.m2272a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.Uf;	 Catch:{ all -> 0x006a }
        r1.m2868a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean iL() {
        ce ju = ce.ju();
        return (ju.jv() == C0436a.CONTAINER || ju.jv() == C0436a.CONTAINER_DEBUG) && this.TM.equals(ju.getContainerId());
    }

    private synchronized void m2881s(long j) {
        if (this.Uj == null) {
            bh.m1273w("Refresh requested, but no network load scheduler.");
        } else {
            this.Uj.m2336d(j, this.Uh.fW);
        }
    }

    private void m2882z(boolean z) {
        this.Ue.m2337a(new C0861b());
        this.Uj.m2335a(new C0862c());
        C0444c bP = this.Ue.bP(this.Ud);
        if (bP != null) {
            this.Uf = new C1015n(this.TY, this.zs, new Container(this.mContext, this.TY.getDataLayer(), this.TM, 0, bP), this.Ub);
        }
        this.Uk = new C08602(this, z);
        if (iL()) {
            this.Uj.m2336d(0, "");
        } else {
            this.Ue.iN();
        }
    }

    protected ContainerHolder m2883O(Status status) {
        if (this.Uf != null) {
            return this.Uf;
        }
        if (status == Status.zS) {
            bh.m1270t("timer expired: setting result to failure");
        }
        return new C1015n(status);
    }

    synchronized void bc(String str) {
        this.Ui = str;
        if (this.Uj != null) {
            this.Uj.bf(str);
        }
    }

    protected /* synthetic */ Result m2884d(Status status) {
        return m2883O(status);
    }

    synchronized String iF() {
        return this.Ui;
    }

    public void iI() {
        C0444c bP = this.Ue.bP(this.Ud);
        if (bP != null) {
            m2272a(new C1015n(this.TY, this.zs, new Container(this.mContext, this.TY.getDataLayer(), this.TM, 0, bP), new C08591(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m1270t(str);
            m2272a(m2883O(new Status(10, str, null)));
        }
        this.Uj = null;
        this.Ue = null;
    }

    public void iJ() {
        m2882z(false);
    }

    public void iK() {
        m2882z(true);
    }
}
