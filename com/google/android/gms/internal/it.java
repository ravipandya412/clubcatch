package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ir.C0981a;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class it implements Creator<C0981a> {
    static void m993a(C0981a c0981a, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0981a.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0981a.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m246c(parcel, 2, c0981a.getMax());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m246c(parcel, 3, c0981a.getMin());
        }
        C0212b.m226D(parcel, p);
    }

    public C0981a aJ(Parcel parcel) {
        int i = 0;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i2 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0981a(hashSet, i3, i2, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0981a[] bG(int i) {
        return new C0981a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bG(x0);
    }
}
