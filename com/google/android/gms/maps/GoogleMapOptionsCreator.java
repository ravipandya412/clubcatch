package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.CameraPosition;
import com.pkr.clubcatch.C0519R;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1120a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
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

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int o = C0211a.m211o(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    b8 = C0211a.m200e(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    b7 = C0211a.m200e(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    cameraPosition = (CameraPosition) C0211a.m191a(parcel, n, CameraPosition.CREATOR);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    b6 = C0211a.m200e(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    b5 = C0211a.m200e(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    b4 = C0211a.m200e(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    b3 = C0211a.m200e(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    b2 = C0211a.m200e(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    b = C0211a.m200e(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
