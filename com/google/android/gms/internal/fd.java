package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.fb.C0696a;
import com.google.android.gms.internal.fe.C0698b;
import com.google.android.gms.location.DetectedActivity;

public class fd implements Creator<C0698b> {
    static void m755a(C0698b c0698b, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, c0698b.versionCode);
        C0212b.m236a(parcel, 2, c0698b.eX, false);
        C0212b.m234a(parcel, 3, c0698b.CI, i, false);
        C0212b.m226D(parcel, p);
    }

    public C0698b[] m756X(int i) {
        return new C0698b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m757u(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m756X(x0);
    }

    public C0698b m757u(Parcel parcel) {
        C0696a c0696a = null;
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
                    c0696a = (C0696a) C0211a.m191a(parcel, n, C0696a.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0698b(i, str, c0696a);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
