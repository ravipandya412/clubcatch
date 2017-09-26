package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class ji implements Creator<jh> {
    static void m1012a(jh jhVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, jhVar.getVersionCode());
        C0212b.m236a(parcel, 2, jhVar.label, false);
        C0212b.m236a(parcel, 3, jhVar.value, false);
        C0212b.m226D(parcel, p);
    }

    public jh bg(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new jh(i, str2, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public jh[] cm(int i) {
        return new jh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cm(x0);
    }
}
