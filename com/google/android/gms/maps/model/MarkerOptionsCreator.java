package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1151a(MarkerOptions markerOptions, Parcel parcel, int i) {
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
        C0212b.m239a(parcel, 10, markerOptions.isFlat());
        C0212b.m229a(parcel, 11, markerOptions.getRotation());
        C0212b.m229a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0212b.m229a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0212b.m229a(parcel, 14, markerOptions.getAlpha());
        C0212b.m226D(parcel, p);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
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
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    iBinder = C0211a.m210n(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    f2 = C0211a.m205j(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    z2 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    z3 = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    f3 = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    f4 = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    f5 = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    f6 = C0211a.m205j(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
