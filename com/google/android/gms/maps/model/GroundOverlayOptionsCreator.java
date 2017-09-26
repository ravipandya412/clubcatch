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

public class GroundOverlayOptionsCreator implements Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1147a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
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

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
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
                    latLng = (LatLng) C0211a.m191a(parcel, n, LatLng.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f2 = C0211a.m205j(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    latLngBounds = (LatLngBounds) C0211a.m191a(parcel, n, LatLngBounds.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    f3 = C0211a.m205j(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    f4 = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    f5 = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    f6 = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    f7 = C0211a.m205j(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
