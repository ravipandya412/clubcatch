package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.ca.C0297a;

public abstract class cb extends ct {
    private final cd mf;
    private final C0297a nY;

    /* renamed from: com.google.android.gms.internal.cb.a */
    public static final class C0943a extends cb {
        private final Context mContext;

        public C0943a(Context context, cd cdVar, C0297a c0297a) {
            super(cdVar, c0297a);
            this.mContext = context;
        }

        public void aD() {
        }

        public ch aE() {
            return ci.m2525a(this.mContext, new av());
        }
    }

    /* renamed from: com.google.android.gms.internal.cb.b */
    public static final class C0944b extends cb implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object mg;
        private final C0297a nY;
        private final cc nZ;

        public C0944b(Context context, cd cdVar, C0297a c0297a) {
            super(cdVar, c0297a);
            this.mg = new Object();
            this.nY = c0297a;
            this.nZ = new cc(context, this, this, cdVar.kN.pW);
            this.nZ.connect();
        }

        public void aD() {
            synchronized (this.mg) {
                if (this.nZ.isConnected() || this.nZ.isConnecting()) {
                    this.nZ.disconnect();
                }
            }
        }

        public ch aE() {
            ch aH;
            synchronized (this.mg) {
                try {
                    aH = this.nZ.aH();
                } catch (IllegalStateException e) {
                    aH = null;
                }
            }
            return aH;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.nY.m472a(new cf(0));
        }

        public void onDisconnected() {
            da.m566s("Disconnected from remote ad request service.");
        }
    }

    public cb(cd cdVar, C0297a c0297a) {
        this.mf = cdVar;
        this.nY = c0297a;
    }

    private static cf m1706a(ch chVar, cd cdVar) {
        try {
            return chVar.m482b(cdVar);
        } catch (Throwable e) {
            da.m564b("Could not fetch ad response from ad request service.", e);
            return null;
        }
    }

    public final void aB() {
        try {
            cf cfVar;
            ch aE = aE();
            if (aE == null) {
                cfVar = new cf(0);
            } else {
                cfVar = m1706a(aE, this.mf);
                if (cfVar == null) {
                    cfVar = new cf(0);
                }
            }
            aD();
            this.nY.m472a(cfVar);
        } catch (Throwable th) {
            aD();
        }
    }

    public abstract void aD();

    public abstract ch aE();

    public final void onStop() {
        aD();
    }
}
