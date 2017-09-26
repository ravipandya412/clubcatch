package com.google.android.gms.internal;

public final class gq {
    public static String aW(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "PUBLIC";
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return "SOCIAL";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
