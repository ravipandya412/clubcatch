package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0145a;
import com.google.android.gms.location.DetectedActivity;
import java.util.Date;
import java.util.HashSet;

public final class bk {

    /* renamed from: com.google.android.gms.internal.bk.1 */
    static /* synthetic */ class C02851 {
        static final /* synthetic */ int[] mW;
        static final /* synthetic */ int[] mX;

        static {
            mX = new int[ErrorCode.values().length];
            try {
                mX[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mX[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mX[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mX[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            mW = new int[Gender.values().length];
            try {
                mW[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                mW[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                mW[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m444a(ErrorCode errorCode) {
        switch (C02851.mX[errorCode.ordinal()]) {
            case DetectedActivity.ON_FOOT /*2*/:
                return 1;
            case DetectedActivity.STILL /*3*/:
                return 2;
            case DetectedActivity.UNKNOWN /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static int m445a(Gender gender) {
        switch (C02851.mW[gender.ordinal()]) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return 2;
            case DetectedActivity.ON_FOOT /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    public static AdSize m446b(ab abVar) {
        return new AdSize(C0145a.m21a(abVar.width, abVar.height, abVar.ln));
    }

    public static MediationAdRequest m447e(C0739z c0739z) {
        return new MediationAdRequest(new Date(c0739z.le), m448g(c0739z.lf), c0739z.lg != null ? new HashSet(c0739z.lg) : null, c0739z.lh);
    }

    public static Gender m448g(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return Gender.MALE;
            case DetectedActivity.ON_FOOT /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static final ErrorCode m449h(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DROPDOWN /*1*/:
                return ErrorCode.INVALID_REQUEST;
            case DetectedActivity.ON_FOOT /*2*/:
                return ErrorCode.NETWORK_ERROR;
            case DetectedActivity.STILL /*3*/:
                return ErrorCode.NO_FILL;
            default:
                return ErrorCode.INTERNAL_ERROR;
        }
    }
}
