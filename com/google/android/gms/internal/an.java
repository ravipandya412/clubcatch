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

public class an implements Creator<am> {
    static void m423a(am amVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, amVar.versionCode);
        C0212b.m246c(parcel, 2, amVar.lI);
        C0212b.m246c(parcel, 3, amVar.backgroundColor);
        C0212b.m246c(parcel, 4, amVar.lJ);
        C0212b.m246c(parcel, 5, amVar.lK);
        C0212b.m246c(parcel, 6, amVar.lL);
        C0212b.m246c(parcel, 7, amVar.lM);
        C0212b.m246c(parcel, 8, amVar.lN);
        C0212b.m246c(parcel, 9, amVar.lO);
        C0212b.m236a(parcel, 10, amVar.lP, false);
        C0212b.m246c(parcel, 11, amVar.lQ);
        C0212b.m236a(parcel, 12, amVar.lR, false);
        C0212b.m246c(parcel, 13, amVar.lS);
        C0212b.m246c(parcel, 14, amVar.lT);
        C0212b.m236a(parcel, 15, amVar.lU, false);
        C0212b.m226D(parcel, p);
    }

    public am m424c(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i4 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i5 = C0211a.m202g(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i6 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i7 = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    i8 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    i9 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    i10 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    i11 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    i12 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginBottom /*15*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new am(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m424c(x0);
    }

    public am[] m425e(int i) {
        return new am[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m425e(x0);
    }
}
