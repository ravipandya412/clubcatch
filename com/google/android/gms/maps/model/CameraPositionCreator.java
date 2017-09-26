package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class CameraPositionCreator implements Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1145a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, cameraPosition.getVersionCode());
        C0212b.m234a(parcel, 2, cameraPosition.target, i, false);
        C0212b.m229a(parcel, 3, cameraPosition.zoom);
        C0212b.m229a(parcel, 4, cameraPosition.tilt);
        C0212b.m229a(parcel, 5, cameraPosition.bearing);
        C0212b.m226D(parcel, p);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int o = C0211a.m211o(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    latLng = (LatLng) C0211a.m191a(parcel, n, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    f3 = C0211a.m205j(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f2 = C0211a.m205j(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public CameraPosition[] newArray(int size) {
        return new CameraPosition[size];
    }
}
