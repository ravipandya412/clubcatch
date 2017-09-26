package com.google.android.gms.internal;

import com.google.android.gms.internal.bc.C0275a;
import com.google.android.gms.internal.bh.C0652a;

public final class ba extends C0652a {
    private C0275a mA;
    private az mB;
    private final Object mg;

    public ba() {
        this.mg = new Object();
    }

    public void m2444O() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m430U();
            }
        }
    }

    public void m2445a(az azVar) {
        synchronized (this.mg) {
            this.mB = azVar;
        }
    }

    public void m2446a(C0275a c0275a) {
        synchronized (this.mg) {
            this.mA = c0275a;
        }
    }

    public void onAdClosed() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m431V();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.mg) {
            if (this.mA != null) {
                this.mA.m435f(error == 3 ? 1 : 2);
                this.mA = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m432W();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.mg) {
            if (this.mA != null) {
                this.mA.m435f(0);
                this.mA = null;
                return;
            }
            if (this.mB != null) {
                this.mB.m434Y();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.mg) {
            if (this.mB != null) {
                this.mB.m433X();
            }
        }
    }
}
