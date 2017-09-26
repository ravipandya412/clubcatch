package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0392d {
    static void m1160a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, latLngBounds.getVersionCode());
        C0212b.m234a(parcel, 2, latLngBounds.southwest, i, false);
        C0212b.m234a(parcel, 3, latLngBounds.northeast, i, false);
        C0212b.m226D(parcel, p);
    }
}
