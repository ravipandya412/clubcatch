package com.google.android.gms.internal;

import com.google.android.gms.location.DetectedActivity;

public final class gu {
    public static String aW(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "DAILY";
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return "WEEKLY";
            case DetectedActivity.ON_FOOT /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
