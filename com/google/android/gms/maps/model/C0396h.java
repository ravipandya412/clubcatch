package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0396h {
    static void m1164a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, polylineOptions.getVersionCode());
        C0212b.m245b(parcel, 2, polylineOptions.getPoints(), false);
        C0212b.m229a(parcel, 3, polylineOptions.getWidth());
        C0212b.m246c(parcel, 4, polylineOptions.getColor());
        C0212b.m229a(parcel, 5, polylineOptions.getZIndex());
        C0212b.m239a(parcel, 6, polylineOptions.isVisible());
        C0212b.m239a(parcel, 7, polylineOptions.isGeodesic());
        C0212b.m226D(parcel, p);
    }
}
