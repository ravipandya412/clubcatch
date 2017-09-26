package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class dy {
    private static final du xE;
    public static final Object yD;
    private long yA;
    private long yB;
    private dx yC;
    private long yz;

    static {
        xE = new du("RequestTracker");
        yD = new Object();
    }

    public dy(long j) {
        this.yz = j;
        this.yA = -1;
        this.yB = 0;
    }

    private void dk() {
        this.yA = -1;
        this.yC = null;
        this.yB = 0;
    }

    public void m647a(long j, dx dxVar) {
        synchronized (yD) {
            dx dxVar2 = this.yC;
            long j2 = this.yA;
            this.yA = j;
            this.yC = dxVar;
            this.yB = SystemClock.elapsedRealtime();
        }
        if (dxVar2 != null) {
            dxVar2.m646k(j2);
        }
    }

    public boolean m648b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        dx dxVar = null;
        synchronized (yD) {
            if (this.yA == -1 || this.yA != j) {
                z = false;
            } else {
                xE.m641b("request %d completed", Long.valueOf(this.yA));
                dxVar = this.yC;
                dk();
            }
        }
        if (dxVar != null) {
            dxVar.m645a(j, i, jSONObject);
        }
        return z;
    }

    public boolean m649c(long j, int i) {
        return m648b(j, i, null);
    }

    public void clear() {
        synchronized (yD) {
            if (this.yA != -1) {
                dk();
            }
        }
    }

    public boolean m650d(long j, int i) {
        dx dxVar;
        boolean z = true;
        long j2 = 0;
        synchronized (yD) {
            if (this.yA == -1 || j - this.yB < this.yz) {
                z = false;
                dxVar = null;
            } else {
                xE.m641b("request %d timed out", Long.valueOf(this.yA));
                j2 = this.yA;
                dxVar = this.yC;
                dk();
            }
        }
        if (dxVar != null) {
            dxVar.m645a(j2, i, null);
        }
        return z;
    }

    public boolean dl() {
        boolean z;
        synchronized (yD) {
            z = this.yA != -1;
        }
        return z;
    }

    public boolean m651m(long j) {
        boolean z;
        synchronized (yD) {
            z = this.yA != -1 && this.yA == j;
        }
        return z;
    }
}
