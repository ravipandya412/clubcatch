package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class TileCreator implements Creator<Tile> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1154a(Tile tile, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, tile.getVersionCode());
        C0212b.m246c(parcel, 2, tile.width);
        C0212b.m246c(parcel, 3, tile.height);
        C0212b.m240a(parcel, 4, tile.data, false);
        C0212b.m226D(parcel, p);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0211a.m211o(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bArr = C0211a.m213p(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
