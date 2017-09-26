package com.google.android.gms.internal;

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

public class bp implements Creator<bq> {
    static void m454a(bq bqVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, bqVar.versionCode);
        C0212b.m234a(parcel, 2, bqVar.nr, i, false);
        C0212b.m232a(parcel, 3, bqVar.at(), false);
        C0212b.m232a(parcel, 4, bqVar.au(), false);
        C0212b.m232a(parcel, 5, bqVar.av(), false);
        C0212b.m232a(parcel, 6, bqVar.aw(), false);
        C0212b.m236a(parcel, 7, bqVar.nw, false);
        C0212b.m239a(parcel, 8, bqVar.nx);
        C0212b.m236a(parcel, 9, bqVar.ny, false);
        C0212b.m232a(parcel, 10, bqVar.ax(), false);
        C0212b.m246c(parcel, 11, bqVar.orientation);
        C0212b.m246c(parcel, 12, bqVar.nA);
        C0212b.m236a(parcel, 13, bqVar.mZ, false);
        C0212b.m234a(parcel, 14, bqVar.kN, i, false);
        C0212b.m226D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m455e(x0);
    }

    public bq m455e(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        bn bnVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        db dbVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    bnVar = (bn) C0211a.m191a(parcel, n, bn.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    iBinder = C0211a.m210n(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    iBinder2 = C0211a.m210n(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    iBinder3 = C0211a.m210n(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    iBinder4 = C0211a.m210n(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleTextAppearance /*9*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_subtitleTextAppearance /*10*/:
                    iBinder5 = C0211a.m210n(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMargins /*11*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginStart /*12*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginEnd /*13*/:
                    str3 = C0211a.m208m(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_titleMarginTop /*14*/:
                    dbVar = (db) C0211a.m191a(parcel, n, db.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new bq(i, bnVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, dbVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public bq[] m456j(int i) {
        return new bq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m456j(x0);
    }
}
