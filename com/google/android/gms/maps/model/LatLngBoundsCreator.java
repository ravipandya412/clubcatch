package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1149a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, latLngBounds.getVersionCode());
        C0212b.m234a(parcel, 2, latLngBounds.southwest, i, false);
        C0212b.m234a(parcel, 3, latLngBounds.northeast, i, false);
        C0212b.m226D(parcel, p);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < o) {
            int g;
            LatLng latLng3;
            int n = C0211a.m209n(parcel);
            LatLng latLng4;
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = C0211a.m202g(parcel, n);
                    latLng3 = latLng4;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    g = i;
                    latLng4 = (LatLng) C0211a.m191a(parcel, n, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case DetectedActivity.STILL /*3*/:
                    latLng3 = (LatLng) C0211a.m191a(parcel, n, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == o) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
