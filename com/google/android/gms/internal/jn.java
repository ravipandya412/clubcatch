package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;
import com.pkr.clubcatch.C0519R;

public class jn implements Creator<jm> {
    static void m1014a(jm jmVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, jmVar.getVersionCode());
        C0212b.m246c(parcel, 2, jmVar.ZE);
        C0212b.m236a(parcel, 3, jmVar.ZF, false);
        C0212b.m228a(parcel, 4, jmVar.ZG);
        C0212b.m236a(parcel, 5, jmVar.ZH, false);
        C0212b.m230a(parcel, 6, jmVar.ZI);
        C0212b.m246c(parcel, 7, jmVar.ZJ);
        C0212b.m226D(parcel, p);
    }

    public jm bi(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    d = C0211a.m206k(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case C0519R.styleable.Toolbar_contentInsetRight /*7*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jm(i3, i, str2, d, str, j, i2);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public jm[] co(int i) {
        return new jm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return co(x0);
    }
}
