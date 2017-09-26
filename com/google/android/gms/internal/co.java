package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class co {
    private final Object mg;
    private boolean oI;
    private final LinkedList<C0300a> pj;
    private final String pk;
    private final String pl;
    private long pm;
    private long pn;
    private long po;
    private long pp;
    private long pq;
    private long pr;

    /* renamed from: com.google.android.gms.internal.co.a */
    private static final class C0300a {
        private long ps;
        private long pt;

        public C0300a() {
            this.ps = -1;
            this.pt = -1;
        }

        public long aM() {
            return this.pt;
        }

        public void aN() {
            this.pt = SystemClock.elapsedRealtime();
        }

        public void aO() {
            this.ps = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.ps);
            bundle.putLong("tclose", this.pt);
            return bundle;
        }
    }

    public co(String str, String str2) {
        this.mg = new Object();
        this.pm = -1;
        this.pn = -1;
        this.oI = false;
        this.po = -1;
        this.pp = 0;
        this.pq = -1;
        this.pr = -1;
        this.pk = str;
        this.pl = str2;
        this.pj = new LinkedList();
    }

    public void aJ() {
        synchronized (this.mg) {
            if (!(this.pr == -1 || this.pn == -1)) {
                this.pn = SystemClock.elapsedRealtime();
                cp.aQ().aJ();
                cp.m518a(this);
            }
        }
    }

    public void aK() {
        synchronized (this.mg) {
            if (this.pr != -1) {
                C0300a c0300a = new C0300a();
                c0300a.aO();
                this.pj.add(c0300a);
                this.pp++;
                cp.aQ().aK();
                cp.m518a(this);
            }
        }
    }

    public void aL() {
        synchronized (this.mg) {
            if (!(this.pr == -1 || this.pj.isEmpty())) {
                C0300a c0300a = (C0300a) this.pj.getLast();
                if (c0300a.aM() == -1) {
                    c0300a.aN();
                    cp.m518a(this);
                }
            }
        }
    }

    public void m512f(C0739z c0739z) {
        synchronized (this.mg) {
            this.pq = SystemClock.elapsedRealtime();
            cp.aQ().m522b(c0739z, this.pq);
        }
    }

    public void m513g(long j) {
        synchronized (this.mg) {
            this.pr = j;
            if (this.pr != -1) {
                cp.m518a(this);
            }
        }
    }

    public void m514h(long j) {
        synchronized (this.mg) {
            if (this.pr != -1) {
                this.pm = j;
                cp.m518a(this);
            }
        }
    }

    public void m515k(boolean z) {
        synchronized (this.mg) {
            if (this.pr != -1) {
                this.po = SystemClock.elapsedRealtime();
                if (!z) {
                    this.pn = this.po;
                    cp.m518a(this);
                }
            }
        }
    }

    public void m516l(boolean z) {
        synchronized (this.mg) {
            if (this.pr != -1) {
                this.oI = z;
                cp.m518a(this);
            }
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.mg) {
            bundle = new Bundle();
            bundle.putString("seqnum", this.pk);
            bundle.putString("slotid", this.pl);
            bundle.putBoolean("ismediation", this.oI);
            bundle.putLong("treq", this.pq);
            bundle.putLong("tresponse", this.pr);
            bundle.putLong("timp", this.pn);
            bundle.putLong("tload", this.po);
            bundle.putLong("pcc", this.pp);
            bundle.putLong("tfetch", this.pm);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.pj.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0300a) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
