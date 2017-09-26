package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ir.C0984b;
import com.google.android.gms.internal.ir.C0984b.C0982a;
import com.google.android.gms.internal.ir.C0984b.C0983b;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class iu implements Creator<C0984b> {
    static void m994a(C0984b c0984b, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0984b.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0984b.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m234a(parcel, 2, c0984b.m2750if(), i, true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m234a(parcel, 3, c0984b.ig(), i, true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m246c(parcel, 4, c0984b.getLayout());
        }
        C0212b.m226D(parcel, p);
    }

    public C0984b aK(Parcel parcel) {
        C0983b c0983b = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        C0982a c0982a = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    C0982a c0982a2 = (C0982a) C0211a.m191a(parcel, n, C0982a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c0982a = c0982a2;
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0983b c0983b2 = (C0983b) C0211a.m191a(parcel, n, C0983b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0983b = c0983b2;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0211a.m202g(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0984b(hashSet, i2, c0982a, c0983b, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0984b[] bH(int i) {
        return new C0984b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bH(x0);
    }
}
