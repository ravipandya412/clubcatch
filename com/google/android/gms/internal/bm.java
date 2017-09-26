package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

public class bm implements Creator<bn> {
    static void m451a(bn bnVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, bnVar.versionCode);
        C0212b.m236a(parcel, 2, bnVar.mY, false);
        C0212b.m236a(parcel, 3, bnVar.mZ, false);
        C0212b.m236a(parcel, 4, bnVar.mimeType, false);
        C0212b.m236a(parcel, 5, bnVar.packageName, false);
        C0212b.m236a(parcel, 6, bnVar.na, false);
        C0212b.m236a(parcel, 7, bnVar.nb, false);
        C0212b.m236a(parcel, 8, bnVar.nc, false);
        C0212b.m226D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m452d(x0);
    }

    public bn m452d(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str7 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str6 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new bn(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public bn[] m453i(int i) {
        return new bn[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m453i(x0);
    }
}
