package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0397i {
    static void m1165a(Tile tile, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, tile.getVersionCode());
        C0212b.m246c(parcel, 2, tile.width);
        C0212b.m246c(parcel, 3, tile.height);
        C0212b.m240a(parcel, 4, tile.data, false);
        C0212b.m226D(parcel, p);
    }
}
