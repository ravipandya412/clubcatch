package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0394f {
    static void m1162a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, markerOptions.getVersionCode());
        C0212b.m234a(parcel, 2, markerOptions.getPosition(), i, false);
        C0212b.m236a(parcel, 3, markerOptions.getTitle(), false);
        C0212b.m236a(parcel, 4, markerOptions.getSnippet(), false);
        C0212b.m232a(parcel, 5, markerOptions.hf(), false);
        C0212b.m229a(parcel, 6, markerOptions.getAnchorU());
        C0212b.m229a(parcel, 7, markerOptions.getAnchorV());
        C0212b.m239a(parcel, 8, markerOptions.isDraggable());
        C0212b.m239a(parcel, 9, markerOptions.isVisible());
        C0212b.m226D(parcel, p);
    }
}
