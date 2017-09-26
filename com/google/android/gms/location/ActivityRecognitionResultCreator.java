package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1115a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m245b(parcel, 1, activityRecognitionResult.KP, false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, activityRecognitionResult.getVersionCode());
        C0212b.m230a(parcel, 2, activityRecognitionResult.KQ);
        C0212b.m230a(parcel, 3, activityRecognitionResult.KR);
        C0212b.m226D(parcel, p);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int o = C0211a.m211o(parcel);
        int i = 0;
        List list = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    list = C0211a.m197c(parcel, n, DetectedActivity.CREATOR);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ActivityRecognitionResult(i, list, j2, j);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
