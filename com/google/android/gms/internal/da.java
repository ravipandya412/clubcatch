package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

public final class da {
    public static void m563a(String str, Throwable th) {
        if (m565n(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m564b(String str, Throwable th) {
        if (m565n(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m565n(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    public static void m566s(String str) {
        if (m565n(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void m567t(String str) {
        if (m565n(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m568u(String str) {
        if (m565n(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m569v(String str) {
        if (m565n(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void m570w(String str) {
        if (m565n(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
