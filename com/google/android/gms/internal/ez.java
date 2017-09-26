package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ey.C0683a;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ez implements Creator<ey> {
    static void m738a(ey eyVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, eyVar.getVersionCode());
        C0212b.m245b(parcel, 2, eyVar.ek(), false);
        C0212b.m226D(parcel, p);
    }

    public ey[] m739U(int i) {
        return new ey[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m740r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m739U(x0);
    }

    public ey m740r(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    arrayList = C0211a.m197c(parcel, n, C0683a.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ey(i, arrayList);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
