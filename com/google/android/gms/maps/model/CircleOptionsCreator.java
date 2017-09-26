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

public class CircleOptionsCreator implements Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1146a(CircleOptions circleOptions, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, circleOptions.getVersionCode());
        C0212b.m234a(parcel, 2, circleOptions.getCenter(), i, false);
        C0212b.m228a(parcel, 3, circleOptions.getRadius());
        C0212b.m229a(parcel, 4, circleOptions.getStrokeWidth());
        C0212b.m246c(parcel, 5, circleOptions.getStrokeColor());
        C0212b.m246c(parcel, 6, circleOptions.getFillColor());
        C0212b.m229a(parcel, 7, circleOptions.getZIndex());
        C0212b.m239a(parcel, 8, circleOptions.isVisible());
        C0212b.m226D(parcel, p);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0211a.m211o(parcel);
        LatLng latLng = null;
        double d = 0.0d;
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
                    latLng = (LatLng) C0211a.m191a(parcel, n, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    d = C0211a.m206k(parcel, n);
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
                    z = C0211a.m198c(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
