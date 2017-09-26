package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.location.DetectedActivity;

public class jw implements Creator<jv> {
    static void m1019a(jv jvVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, jvVar.getVersionCode());
        C0212b.m236a(parcel, 2, jvVar.ZK, false);
        C0212b.m236a(parcel, 3, jvVar.oi, false);
        C0212b.m234a(parcel, 4, jvVar.ZO, i, false);
        C0212b.m234a(parcel, 5, jvVar.ZP, i, false);
        C0212b.m234a(parcel, 6, jvVar.ZQ, i, false);
        C0212b.m226D(parcel, p);
    }

    public jv bn(Parcel parcel) {
        jt jtVar = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        jt jtVar2 = null;
        jr jrVar = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    jrVar = (jr) C0211a.m191a(parcel, n, jr.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    jtVar2 = (jt) C0211a.m191a(parcel, n, jt.CREATOR);
                    break;
                case Participant.STATUS_UNRESPONSIVE /*6*/:
                    jtVar = (jt) C0211a.m191a(parcel, n, jt.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jv(i, str2, str, jrVar, jtVar2, jtVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bn(x0);
    }

    public jv[] ct(int i) {
        return new jv[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ct(x0);
    }
}
