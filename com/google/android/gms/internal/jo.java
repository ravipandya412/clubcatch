package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class jo implements Creator<jl> {
    static void m1015a(jl jlVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, jlVar.getVersionCode());
        C0212b.m236a(parcel, 2, jlVar.label, false);
        C0212b.m234a(parcel, 3, jlVar.ZD, i, false);
        C0212b.m236a(parcel, 4, jlVar.type, false);
        C0212b.m234a(parcel, 5, jlVar.YM, i, false);
        C0212b.m226D(parcel, p);
    }

    public jl bj(Parcel parcel) {
        jr jrVar = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        jm jmVar = null;
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
                    jmVar = (jm) C0211a.m191a(parcel, n, jm.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    jrVar = (jr) C0211a.m191a(parcel, n, jr.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jl(i, str2, jmVar, str, jrVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public jl[] cp(int i) {
        return new jl[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cp(x0);
    }
}
