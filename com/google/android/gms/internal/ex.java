package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class ex implements Creator<ew> {
    static void m735a(ew ewVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, ewVar.getVersionCode());
        C0212b.m234a(parcel, 2, ewVar.ei(), i, false);
        C0212b.m226D(parcel, p);
    }

    public ew[] m736T(int i) {
        return new ew[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m737q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m736T(x0);
    }

    public ew m737q(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        ey eyVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    eyVar = (ey) C0211a.m191a(parcel, n, ey.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ew(i, eyVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
