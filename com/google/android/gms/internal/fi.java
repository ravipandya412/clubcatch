package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class fi implements Creator<fh> {
    static void m764a(fh fhVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, fhVar.getVersionCode());
        C0212b.m233a(parcel, 2, fhVar.eF(), false);
        C0212b.m234a(parcel, 3, fhVar.eG(), i, false);
        C0212b.m226D(parcel, p);
    }

    public fh[] aa(int i) {
        return new fh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m765x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aa(x0);
    }

    public fh m765x(Parcel parcel) {
        fe feVar = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    parcel2 = C0211a.m223z(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    feVar = (fe) C0211a.m191a(parcel, n, fe.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new fh(i, parcel2, feVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
