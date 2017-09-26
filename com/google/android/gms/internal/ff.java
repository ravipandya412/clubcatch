package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.fe.C0697a;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ff implements Creator<fe> {
    static void m758a(fe feVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, feVar.getVersionCode());
        C0212b.m245b(parcel, 2, feVar.eC(), false);
        C0212b.m236a(parcel, 3, feVar.eD(), false);
        C0212b.m226D(parcel, p);
    }

    public fe[] m759Y(int i) {
        return new fe[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m760v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m759Y(x0);
    }

    public fe m760v(Parcel parcel) {
        String str = null;
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
                    arrayList = C0211a.m197c(parcel, n, C0697a.CREATOR);
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
            return new fe(i, arrayList, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
