package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.maps.a */
public class C0370a {
    static void m1121a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, googleMapOptions.getVersionCode());
        C0212b.m227a(parcel, 2, googleMapOptions.gN());
        C0212b.m227a(parcel, 3, googleMapOptions.gO());
        C0212b.m246c(parcel, 4, googleMapOptions.getMapType());
        C0212b.m234a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0212b.m227a(parcel, 6, googleMapOptions.gP());
        C0212b.m227a(parcel, 7, googleMapOptions.gQ());
        C0212b.m227a(parcel, 8, googleMapOptions.gR());
        C0212b.m227a(parcel, 9, googleMapOptions.gS());
        C0212b.m227a(parcel, 10, googleMapOptions.gT());
        C0212b.m227a(parcel, 11, googleMapOptions.gU());
        C0212b.m226D(parcel, p);
    }
}
