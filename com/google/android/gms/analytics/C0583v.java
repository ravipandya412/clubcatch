package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0164k.C0163a;

/* renamed from: com.google.android.gms.analytics.v */
class C0583v extends C0164k<C0584w> {

    /* renamed from: com.google.android.gms.analytics.v.a */
    private static class C0582a implements C0163a<C0584w> {
        private final C0584w tx;

        public C0582a() {
            this.tx = new C0584w();
        }

        public void m1493a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.tx.tz = i;
            } else {
                aa.m51w("int configuration name not recognized:  " + str);
            }
        }

        public void m1494a(String str, String str2) {
        }

        public void m1495b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.tx.qR = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.tx.qS = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.tx.ty = str2;
            } else {
                aa.m51w("string configuration name not recognized:  " + str);
            }
        }

        public C0584w bU() {
            return this.tx;
        }

        public /* synthetic */ C0162j bz() {
            return bU();
        }

        public void m1496c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.tx.tA = z ? 1 : 0;
                return;
            }
            aa.m51w("bool configuration name not recognized:  " + str);
        }
    }

    public C0583v(Context context) {
        super(context, new C0582a());
    }
}
