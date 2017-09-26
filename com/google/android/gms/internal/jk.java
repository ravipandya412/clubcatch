package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class jk implements Creator<jj> {
    static void m1013a(jj jjVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, jjVar.getVersionCode());
        C0212b.m236a(parcel, 2, jjVar.ZA, false);
        C0212b.m236a(parcel, 3, jjVar.ZB, false);
        C0212b.m245b(parcel, 4, jjVar.ZC, false);
        C0212b.m226D(parcel, p);
    }

    public jj bh(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        ArrayList eH = fj.eH();
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
                    eH = C0211a.m197c(parcel, n, jh.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jj(i, str2, str, eH);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public jj[] cn(int i) {
        return new jj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cn(x0);
    }
}
