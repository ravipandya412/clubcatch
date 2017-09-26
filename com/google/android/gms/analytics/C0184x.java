package com.google.android.gms.analytics;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.analytics.x */
class C0184x {
    private String tK;
    private final long tL;
    private final long tM;
    private String tN;

    C0184x(String str, long j, long j2) {
        this.tN = "https:";
        this.tK = str;
        this.tL = j;
        this.tM = j2;
    }

    void m86E(String str) {
        this.tK = str;
    }

    void m87F(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.tN = "http:";
        }
    }

    String ch() {
        return this.tK;
    }

    long ci() {
        return this.tL;
    }

    long cj() {
        return this.tM;
    }

    String ck() {
        return this.tN;
    }
}
