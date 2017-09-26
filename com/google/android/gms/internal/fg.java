package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.fe.C0697a;
import com.google.android.gms.internal.fe.C0698b;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class fg implements Creator<C0697a> {
    static void m761a(C0697a c0697a, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, c0697a.versionCode);
        C0212b.m236a(parcel, 2, c0697a.className, false);
        C0212b.m245b(parcel, 3, c0697a.CH, false);
        C0212b.m226D(parcel, p);
    }

    public C0697a[] m762Z(int i) {
        return new C0697a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m763w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m762Z(x0);
    }

    public C0697a m763w(Parcel parcel) {
        ArrayList arrayList = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
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
                    arrayList = C0211a.m197c(parcel, n, C0698b.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0697a(i, str, arrayList);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
