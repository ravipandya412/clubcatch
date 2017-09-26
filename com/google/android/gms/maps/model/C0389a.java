package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0389a {
    static void m1157a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, cameraPosition.getVersionCode());
        C0212b.m234a(parcel, 2, cameraPosition.target, i, false);
        C0212b.m229a(parcel, 3, cameraPosition.zoom);
        C0212b.m229a(parcel, 4, cameraPosition.tilt);
        C0212b.m229a(parcel, 5, cameraPosition.bearing);
        C0212b.m226D(parcel, p);
    }
}
