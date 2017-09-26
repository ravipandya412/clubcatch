package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.List;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1153a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, polylineOptions.getVersionCode());
        C0212b.m245b(parcel, 2, polylineOptions.getPoints(), false);
        C0212b.m229a(parcel, 3, polylineOptions.getWidth());
        C0212b.m246c(parcel, 4, polylineOptions.getColor());
        C0212b.m229a(parcel, 5, polylineOptions.getZIndex());
        C0212b.m239a(parcel, 6, polylineOptions.isVisible());
        C0212b.m239a(parcel, 7, polylineOptions.isGeodesic());
        C0212b.m226D(parcel, p);
    }

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0211a.m211o(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    list = C0211a.m197c(parcel, n, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    f2 = C0211a.m205j(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
