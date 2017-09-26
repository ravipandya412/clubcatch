package com.google.android.gms.internal;

import android.util.Log;

public final class el {
    private final String Cd;

    public el(String str) {
        this.Cd = (String) er.m725f(str);
    }

    public boolean m685Q(int i) {
        return Log.isLoggable(this.Cd, i);
    }

    public void m686a(String str, String str2, Throwable th) {
        if (m685Q(6)) {
            Log.e(str, str2, th);
        }
    }

    public void m687f(String str, String str2) {
        if (m685Q(2)) {
            Log.v(str, str2);
        }
    }

    public void m688g(String str, String str2) {
        if (m685Q(5)) {
            Log.w(str, str2);
        }
    }

    public void m689h(String str, String str2) {
        if (m685Q(6)) {
            Log.e(str, str2);
        }
    }
}
