package com.google.android.gms.internal;

import com.google.android.gms.location.DetectedActivity;

public final class gs {
    public static String aW(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return "GIFT";
            case DetectedActivity.ON_FOOT /*2*/:
                return "WISH";
            default:
                fz.m781h("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
