package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C0870x implements bi {
    private int rc;

    C0870x() {
        this.rc = 5;
    }

    public void m2357b(String str, Throwable th) {
        if (this.rc <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void m2358c(String str, Throwable th) {
        if (this.rc <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void m2359s(String str) {
        if (this.rc <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void setLogLevel(int logLevel) {
        this.rc = logLevel;
    }

    public void m2360t(String str) {
        if (this.rc <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void m2361u(String str) {
        if (this.rc <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void m2362v(String str) {
        if (this.rc <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void m2363w(String str) {
        if (this.rc <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }
}
