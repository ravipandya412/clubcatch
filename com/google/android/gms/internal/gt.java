package com.google.android.gms.internal;

import com.google.android.gms.location.DetectedActivity;

public final class gt {
    public static boolean isValid(int outcome) {
        switch (outcome) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
            case DetectedActivity.ON_FOOT /*2*/:
            case DetectedActivity.STILL /*3*/:
                return true;
            default:
                return false;
        }
    }
}
