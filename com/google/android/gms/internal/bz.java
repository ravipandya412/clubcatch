package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.by.C0291a;
import com.google.android.gms.internal.ca.C0297a;
import com.google.android.gms.internal.cd.C0298a;
import com.google.android.gms.internal.de.C0309a;
import org.json.JSONException;

public final class bz extends ct implements C0297a, C0309a {
    private final bf kH;
    private final Context mContext;
    private final Object mg;
    private ay mh;
    private final C0291a nM;
    private final Object nN;
    private final C0298a nO;
    private final C0355l nP;
    private ct nQ;
    private cf nR;
    private boolean nS;
    private aw nT;
    private bc nU;
    private final dd ng;

    /* renamed from: com.google.android.gms.internal.bz.1 */
    class C02921 implements Runnable {
        final /* synthetic */ bz nV;

        C02921(bz bzVar) {
            this.nV = bzVar;
        }

        public void run() {
            this.nV.onStop();
        }
    }

    /* renamed from: com.google.android.gms.internal.bz.2 */
    class C02932 implements Runnable {
        final /* synthetic */ bz nV;
        final /* synthetic */ cn nW;

        C02932(bz bzVar, cn cnVar) {
            this.nV = bzVar;
            this.nW = cnVar;
        }

        public void run() {
            synchronized (this.nV.mg) {
                this.nV.nM.m470a(this.nW);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bz.3 */
    class C02943 implements Runnable {
        final /* synthetic */ bz nV;

        C02943(bz bzVar) {
            this.nV = bzVar;
        }

        public void run() {
            synchronized (this.nV.mg) {
                if (this.nV.nR.errorCode != -2) {
                    return;
                }
                this.nV.ng.bb().m586a(this.nV);
                if (this.nV.nR.errorCode == -3) {
                    da.m569v("Loading URL in WebView: " + this.nV.nR.nw);
                    this.nV.ng.loadUrl(this.nV.nR.nw);
                } else {
                    da.m569v("Loading HTML in WebView.");
                    this.nV.ng.loadDataWithBaseURL(cv.m547p(this.nV.nR.nw), this.nV.nR.oi, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.bz.a */
    private static final class C0295a extends Exception {
        private final int nX;

        public C0295a(String str, int i) {
            super(str);
            this.nX = i;
        }

        public int getErrorCode() {
            return this.nX;
        }
    }

    public bz(Context context, C0298a c0298a, C0355l c0355l, dd ddVar, bf bfVar, C0291a c0291a) {
        this.nN = new Object();
        this.mg = new Object();
        this.nS = false;
        this.kH = bfVar;
        this.nM = c0291a;
        this.ng = ddVar;
        this.mContext = context;
        this.nO = c0298a;
        this.nP = c0355l;
    }

    private ab m1694a(cd cdVar) throws C0295a {
        if (this.nR.on == null) {
            throw new C0295a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.nR.on.split("x");
        if (split.length != 2) {
            throw new C0295a("Could not parse the ad size from the ad response: " + this.nR.on, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (ab abVar : cdVar.kQ.lp) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = abVar.width == -1 ? (int) (((float) abVar.widthPixels) / f) : abVar.width;
                int i2 = abVar.height == -2 ? (int) (((float) abVar.heightPixels) / f) : abVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new ab(abVar, cdVar.kQ.lp);
                }
            }
            throw new C0295a("The ad size from the ad response was not one of the requested sizes: " + this.nR.on, 0);
        } catch (NumberFormatException e) {
            throw new C0295a("Could not parse the ad size from the ad response: " + this.nR.on, 0);
        }
    }

    private void m1696a(cd cdVar, long j) throws C0295a {
        synchronized (this.nN) {
            this.nT = new aw(this.mContext, cdVar, this.kH, this.mh);
        }
        this.nU = this.nT.m428a(j, 60000);
        switch (this.nU.mL) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                throw new C0295a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0295a("Unexpected mediation result: " + this.nU.mL, 0);
        }
    }

    private void aC() throws C0295a {
        if (this.nR.errorCode != -3) {
            if (TextUtils.isEmpty(this.nR.oi)) {
                throw new C0295a("No fill from ad server.", 3);
            } else if (this.nR.ok) {
                try {
                    this.mh = new ay(this.nR.oi);
                } catch (JSONException e) {
                    throw new C0295a("Could not parse mediation config: " + this.nR.oi, 0);
                }
            }
        }
    }

    private void m1698b(long j) throws C0295a {
        cz.pT.post(new C02943(this));
        m1702d(j);
    }

    private void m1700c(long j) throws C0295a {
        while (m1703e(j)) {
            if (this.nR != null) {
                synchronized (this.nN) {
                    this.nQ = null;
                }
                if (this.nR.errorCode != -2 && this.nR.errorCode != -3) {
                    throw new C0295a("There was a problem getting an ad response. ErrorCode: " + this.nR.errorCode, this.nR.errorCode);
                }
                return;
            }
        }
        throw new C0295a("Timed out waiting for ad response.", 2);
    }

    private void m1702d(long j) throws C0295a {
        while (m1703e(j)) {
            if (this.nS) {
                return;
            }
        }
        throw new C0295a("Timed out waiting for WebView to finish loading.", 2);
    }

    private boolean m1703e(long j) throws C0295a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.mg.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0295a("Ad request cancelled.", -1);
        }
    }

    public void m1704a(cf cfVar) {
        synchronized (this.mg) {
            da.m566s("Received ad response.");
            this.nR = cfVar;
            this.mg.notify();
        }
    }

    public void m1705a(dd ddVar) {
        synchronized (this.mg) {
            da.m566s("WebView finished loading.");
            this.nS = true;
            this.mg.notify();
        }
    }

    public void aB() {
        synchronized (this.mg) {
            long j;
            ab abVar;
            da.m566s("AdLoaderBackgroundTask started.");
            cd cdVar = new cd(this.nO, this.nP.m1082y().m948a(this.mContext));
            ab abVar2 = null;
            int i = -2;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ct a = ca.m473a(this.mContext, cdVar, this);
                synchronized (this.nN) {
                    this.nQ = a;
                    if (this.nQ == null) {
                        throw new C0295a("Could not start the ad request service.", 0);
                    }
                }
                m1700c(elapsedRealtime);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                aC();
                if (cdVar.kQ.lp != null) {
                    abVar2 = m1694a(cdVar);
                }
                if (this.nR.ok) {
                    m1696a(cdVar, elapsedRealtime);
                } else {
                    m1698b(elapsedRealtime);
                }
                j = elapsedRealtime2;
                abVar = abVar2;
            } catch (C0295a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    da.m568u(e.getMessage());
                } else {
                    da.m570w(e.getMessage());
                }
                this.nR = new cf(i);
                cz.pT.post(new C02921(this));
                j = -1;
                abVar = null;
            }
            cz.pT.post(new C02932(this, new cn(cdVar.oc, this.ng, this.nR.mt, i, this.nR.mu, this.nR.om, this.nR.orientation, this.nR.mx, cdVar.of, this.nR.ok, this.nU != null ? this.nU.mM : null, this.nU != null ? this.nU.mN : null, this.nU != null ? this.nU.mO : null, this.mh, this.nU != null ? this.nU.mP : null, this.nR.ol, abVar, this.nR.oj, j, this.nR.oo)));
        }
    }

    public void onStop() {
        synchronized (this.nN) {
            if (this.nQ != null) {
                this.nQ.cancel();
            }
            this.ng.stopLoading();
            cv.m534a(this.ng);
            if (this.nT != null) {
                this.nT.cancel();
            }
        }
    }
}
