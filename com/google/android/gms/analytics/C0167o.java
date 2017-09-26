package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.o */
final class C0167o {
    private static String m78b(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        aa.m48t("index out of range for " + str + " (" + i + ")");
        return "";
    }

    static String m79q(int i) {
        return C0167o.m78b("&cd", i);
    }

    static String m80r(int i) {
        return C0167o.m78b("&cm", i);
    }
}
