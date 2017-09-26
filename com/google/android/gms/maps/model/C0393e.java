package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0393e {
    static void m1161a(LatLng latLng, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, latLng.getVersionCode());
        C0212b.m228a(parcel, 2, latLng.latitude);
        C0212b.m228a(parcel, 3, latLng.longitude);
        C0212b.m226D(parcel, p);
    }
}
