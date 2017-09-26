package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0390b {
    static void m1158a(CircleOptions circleOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, circleOptions.getVersionCode());
        C0212b.m234a(parcel, 2, circleOptions.getCenter(), i, false);
        C0212b.m228a(parcel, 3, circleOptions.getRadius());
        C0212b.m229a(parcel, 4, circleOptions.getStrokeWidth());
        C0212b.m246c(parcel, 5, circleOptions.getStrokeColor());
        C0212b.m246c(parcel, 6, circleOptions.getFillColor());
        C0212b.m229a(parcel, 7, circleOptions.getZIndex());
        C0212b.m239a(parcel, 8, circleOptions.isVisible());
        C0212b.m226D(parcel, p);
    }
}
