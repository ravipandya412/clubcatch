package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ir.C0984b.C0983b;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class iw implements Creator<C0983b> {
    static void m996a(C0983b c0983b, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        Set hB = c0983b.hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0212b.m246c(parcel, 1, c0983b.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0212b.m246c(parcel, 2, c0983b.getHeight());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0212b.m236a(parcel, 3, c0983b.getUrl(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0212b.m246c(parcel, 4, c0983b.getWidth());
        }
        C0212b.m226D(parcel, p);
    }

    public C0983b aM(Parcel parcel) {
        int i = 0;
        int o = C0211a.m211o(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = C0211a.m208m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
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
            return new C0983b(hashSet, i3, i2, str, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0983b[] bJ(int i) {
        return new C0983b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bJ(x0);
    }
}
