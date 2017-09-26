package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ey.C0683a;
import com.google.android.gms.location.DetectedActivity;

public class fa implements Creator<C0683a> {
    static void m743a(C0683a c0683a, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, c0683a.versionCode);
        C0212b.m236a(parcel, 2, c0683a.Cs, false);
        C0212b.m246c(parcel, 3, c0683a.Ct);
        C0212b.m226D(parcel, p);
    }

    public C0683a[] m744V(int i) {
        return new C0683a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m745s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m744V(x0);
    }

    public C0683a m745s(Parcel parcel) {
        int i = 0;
        int o = C0211a.m211o(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0683a(i2, str, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
