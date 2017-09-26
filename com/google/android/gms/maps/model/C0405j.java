package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0405j {
    static void m1176a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0212b.m232a(parcel, 2, tileOverlayOptions.hh(), false);
        C0212b.m239a(parcel, 3, tileOverlayOptions.isVisible());
        C0212b.m229a(parcel, 4, tileOverlayOptions.getZIndex());
        C0212b.m226D(parcel, p);
    }
}
