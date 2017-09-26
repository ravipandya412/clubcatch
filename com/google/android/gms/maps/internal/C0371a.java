package com.google.android.gms.maps.internal;

/* renamed from: com.google.android.gms.maps.internal.a */
public final class C0371a {
    public static Boolean m1122a(byte b) {
        switch (b) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return Boolean.FALSE;
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte m1123c(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
