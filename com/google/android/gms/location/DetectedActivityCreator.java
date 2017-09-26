package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;

public class DetectedActivityCreator implements Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1116a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, detectedActivity.KS);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, detectedActivity.getVersionCode());
        C0212b.m246c(parcel, 2, detectedActivity.KT);
        C0212b.m226D(parcel, p);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0211a.m211o(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
