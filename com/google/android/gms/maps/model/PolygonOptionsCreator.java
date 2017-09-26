package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1152a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, polygonOptions.getVersionCode());
        C0212b.m245b(parcel, 2, polygonOptions.getPoints(), false);
        C0212b.m247c(parcel, 3, polygonOptions.hg(), false);
        C0212b.m229a(parcel, 4, polygonOptions.getStrokeWidth());
        C0212b.m246c(parcel, 5, polygonOptions.getStrokeColor());
        C0212b.m246c(parcel, 6, polygonOptions.getFillColor());
        C0212b.m229a(parcel, 7, polygonOptions.getZIndex());
        C0212b.m239a(parcel, 8, polygonOptions.isVisible());
        C0212b.m239a(parcel, 9, polygonOptions.isGeodesic());
        C0212b.m226D(parcel, p);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0211a.m211o(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    list = C0211a.m197c(parcel, n, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0211a.m194a(parcel, n, arrayList, getClass().getClassLoader());
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f2 = C0211a.m205j(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
