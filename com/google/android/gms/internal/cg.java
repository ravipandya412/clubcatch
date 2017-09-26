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
import java.util.List;

public class cg implements Creator<cf> {
    static void m479a(cf cfVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, cfVar.versionCode);
        C0212b.m236a(parcel, 2, cfVar.nw, false);
        C0212b.m236a(parcel, 3, cfVar.oi, false);
        C0212b.m237a(parcel, 4, cfVar.mt, false);
        C0212b.m246c(parcel, 5, cfVar.errorCode);
        C0212b.m237a(parcel, 6, cfVar.mu, false);
        C0212b.m230a(parcel, 7, cfVar.oj);
        C0212b.m239a(parcel, 8, cfVar.ok);
        C0212b.m230a(parcel, 9, cfVar.ol);
        C0212b.m237a(parcel, 10, cfVar.om, false);
        C0212b.m230a(parcel, 11, cfVar.mx);
        C0212b.m246c(parcel, 12, cfVar.orientation);
        C0212b.m236a(parcel, 13, cfVar.on, false);
        C0212b.m230a(parcel, 14, cfVar.oo);
        C0212b.m226D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m480g(x0);
    }

    public cf m480g(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    list = C0211a.m222y(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    list2 = C0211a.m222y(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    list3 = C0211a.m222y(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    j3 = C0211a.m203h(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    j4 = C0211a.m203h(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cf(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public cf[] m481l(int i) {
        return new cf[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m481l(x0);
    }
}
