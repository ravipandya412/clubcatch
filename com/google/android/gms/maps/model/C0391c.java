package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0391c {
    static void m1159a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0212b.m232a(parcel, 2, groundOverlayOptions.he(), false);
        C0212b.m234a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0212b.m229a(parcel, 4, groundOverlayOptions.getWidth());
        C0212b.m229a(parcel, 5, groundOverlayOptions.getHeight());
        C0212b.m234a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0212b.m229a(parcel, 7, groundOverlayOptions.getBearing());
        C0212b.m229a(parcel, 8, groundOverlayOptions.getZIndex());
        C0212b.m239a(parcel, 9, groundOverlayOptions.isVisible());
        C0212b.m229a(parcel, 10, groundOverlayOptions.getTransparency());
        C0212b.m229a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0212b.m229a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0212b.m226D(parcel, p);
    }
}
