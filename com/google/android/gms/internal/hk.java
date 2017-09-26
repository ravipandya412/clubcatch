package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.pkr.clubcatch.C0519R;

public class hk implements Creator<hj> {
    static void m977a(hj hjVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, hjVar.getRequestId(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hjVar.getVersionCode());
        C0212b.m230a(parcel, 2, hjVar.getExpirationTime());
        C0212b.m238a(parcel, 3, hjVar.gn());
        C0212b.m228a(parcel, 4, hjVar.getLatitude());
        C0212b.m228a(parcel, 5, hjVar.getLongitude());
        C0212b.m229a(parcel, 6, hjVar.go());
        C0212b.m246c(parcel, 7, hjVar.gp());
        C0212b.m246c(parcel, 8, hjVar.getNotificationResponsiveness());
        C0212b.m246c(parcel, 9, hjVar.gq());
        C0212b.m226D(parcel, p);
    }

    public hj av(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    s = C0211a.m201f(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    d = C0211a.m206k(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    d2 = C0211a.m206k(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    f = C0211a.m205j(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    i4 = C0211a.m202g(parcel, n);
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
            return new hj(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public hj[] bp(int i) {
        return new hj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return av(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bp(x0);
    }
}
