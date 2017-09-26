package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ir.C0985c;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class ix implements Creator<C0985c> {
    static void m997a(C0985c c0985c, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0985c.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0985c.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m236a(parcel, 2, c0985c.getUrl(), true);
        }
        C0212b.m226D(parcel, p);
    }

    public C0985c aN(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0985c(hashSet, i, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0985c[] bK(int i) {
        return new C0985c[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bK(x0);
    }
}
