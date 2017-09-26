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

public class ac implements Creator<ab> {
    static void m385a(ab abVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, abVar.versionCode);
        C0212b.m236a(parcel, 2, abVar.ln, false);
        C0212b.m246c(parcel, 3, abVar.height);
        C0212b.m246c(parcel, 4, abVar.heightPixels);
        C0212b.m239a(parcel, 5, abVar.lo);
        C0212b.m246c(parcel, 6, abVar.width);
        C0212b.m246c(parcel, 7, abVar.widthPixels);
        C0212b.m241a(parcel, 8, abVar.lp, i, false);
        C0212b.m226D(parcel, p);
    }

    public ab m386b(Parcel parcel) {
        ab[] abVarArr = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i5 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i4 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE /*8*/:
                    abVarArr = (ab[]) C0211a.m196b(parcel, n, ab.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ab(i5, str, i4, i3, z, i2, i, abVarArr);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public ab[] m387c(int i) {
        return new ab[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m386b(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m387c(x0);
    }
}
