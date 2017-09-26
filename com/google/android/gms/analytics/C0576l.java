package com.google.android.gms.analytics;

import android.util.Log;

/* renamed from: com.google.android.gms.analytics.l */
class C0576l implements Logger {
    private int rc;

    C0576l() {
        this.rc = 1;
    }

    private String m1451z(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.rc <= 3) {
            Log.e("GAV3", null, exception);
        }
    }

    public void error(String msg) {
        if (this.rc <= 3) {
            Log.e("GAV3", m1451z(msg));
        }
    }

    public int getLogLevel() {
        return this.rc;
    }

    public void info(String msg) {
        if (this.rc <= 1) {
            Log.i("GAV3", m1451z(msg));
        }
    }

    public void setLogLevel(int level) {
        this.rc = level;
    }

    public void verbose(String msg) {
        if (this.rc <= 0) {
            Log.v("GAV3", m1451z(msg));
        }
    }

    public void warn(String msg) {
        if (this.rc <= 2) {
            Log.w("GAV3", m1451z(msg));
        }
    }
}
