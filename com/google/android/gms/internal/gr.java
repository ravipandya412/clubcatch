package com.google.android.gms.internal;

import com.google.android.gms.location.DetectedActivity;

public final class gr {
    public static boolean isValid(int result) {
        switch (result) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
            case DetectedActivity.ON_FOOT /*2*/:
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
            case DetectedActivity.TILTING /*5*/:
                return true;
            default:
                return false;
        }
    }
}
