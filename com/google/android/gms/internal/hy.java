package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.pkr.clubcatch.C0519R;
import java.util.List;

public class hy implements Creator<hx> {
    static void m984a(hx hxVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, hxVar.getId(), false);
        C0212b.m231a(parcel, 2, hxVar.gE(), false);
        C0212b.m234a(parcel, 3, hxVar.gF(), i, false);
        C0212b.m234a(parcel, 4, hxVar.gx(), i, false);
        C0212b.m229a(parcel, 5, hxVar.gy());
        C0212b.m234a(parcel, 6, hxVar.gz(), i, false);
        C0212b.m236a(parcel, 7, hxVar.gG(), false);
        C0212b.m234a(parcel, 8, hxVar.gA(), i, false);
        C0212b.m239a(parcel, 9, hxVar.gB());
        C0212b.m229a(parcel, 10, hxVar.getRating());
        C0212b.m246c(parcel, 11, hxVar.gC());
        C0212b.m230a(parcel, 12, hxVar.gD());
        C0212b.m245b(parcel, 13, hxVar.gw(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hxVar.wj);
        C0212b.m226D(parcel, p);
    }

    public hx aB(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        List list = null;
        Bundle bundle = null;
        hz hzVar = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str2 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    bundle = C0211a.m212o(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    hzVar = (hz) C0211a.m191a(parcel, n, hz.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    latLng = (LatLng) C0211a.m191a(parcel, n, LatLng.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    latLngBounds = (LatLngBounds) C0211a.m191a(parcel, n, LatLngBounds.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    uri = (Uri) C0211a.m191a(parcel, n, Uri.CREATOR);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    f2 = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    list = C0211a.m197c(parcel, n, ht.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new hx(i, str, list, bundle, hzVar, latLng, f, latLngBounds, str2, uri, z, f2, i2, j);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public hx[] bw(int i) {
        return new hx[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bw(x0);
    }
}
