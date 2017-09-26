package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ir.C0988g;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class ja implements Creator<C0988g> {
    static void m1000a(C0988g c0988g, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0988g.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0988g.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m239a(parcel, 2, c0988g.isPrimary());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m236a(parcel, 3, c0988g.getValue(), true);
        }
        C0212b.m226D(parcel, p);
    }

    public C0988g aQ(Parcel parcel) {
        boolean z = false;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    z = C0211a.m198c(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0988g(hashSet, i, z, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0988g[] bN(int i) {
        return new C0988g[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bN(x0);
    }
}
