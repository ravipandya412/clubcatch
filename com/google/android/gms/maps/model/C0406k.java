package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0406k {
    static void m1177a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, visibleRegion.getVersionCode());
        C0212b.m234a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0212b.m234a(parcel, 3, visibleRegion.nearRight, i, false);
        C0212b.m234a(parcel, 4, visibleRegion.farLeft, i, false);
        C0212b.m234a(parcel, 5, visibleRegion.farRight, i, false);
        C0212b.m234a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0212b.m226D(parcel, p);
    }
}
