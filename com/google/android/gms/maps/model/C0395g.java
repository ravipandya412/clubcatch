package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0395g {
    static void m1163a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, polygonOptions.getVersionCode());
        C0212b.m245b(parcel, 2, polygonOptions.getPoints(), false);
        C0212b.m247c(parcel, 3, polygonOptions.hg(), false);
        C0212b.m229a(parcel, 4, polygonOptions.getStrokeWidth());
        C0212b.m246c(parcel, 5, polygonOptions.getStrokeColor());
        C0212b.m246c(parcel, 6, polygonOptions.getFillColor());
        C0212b.m229a(parcel, 7, polygonOptions.getZIndex());
        C0212b.m239a(parcel, 8, polygonOptions.isVisible());
        C0212b.m239a(parcel, 9, polygonOptions.isGeodesic());
        C0212b.m226D(parcel, p);
    }
}
