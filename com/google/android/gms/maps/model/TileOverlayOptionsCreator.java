package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class TileOverlayOptionsCreator implements Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1155a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0212b.m232a(parcel, 2, tileOverlayOptions.hh(), false);
        C0212b.m239a(parcel, 3, tileOverlayOptions.isVisible());
        C0212b.m229a(parcel, 4, tileOverlayOptions.getZIndex());
        C0212b.m239a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0212b.m226D(parcel, p);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0211a.m211o(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    iBinder = C0211a.m210n(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
