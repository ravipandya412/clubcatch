package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1150a(LatLng latLng, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, latLng.getVersionCode());
        C0212b.m228a(parcel, 2, latLng.latitude);
        C0212b.m228a(parcel, 3, latLng.longitude);
        C0212b.m226D(parcel, p);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int o = C0211a.m211o(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    d2 = C0211a.m206k(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    d = C0211a.m206k(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LatLng(i, d2, d);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
