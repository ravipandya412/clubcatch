package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class dc implements Creator<db> {
    static void m571a(db dbVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, dbVar.versionCode);
        C0212b.m236a(parcel, 2, dbVar.pU, false);
        C0212b.m246c(parcel, 3, dbVar.pV);
        C0212b.m246c(parcel, 4, dbVar.pW);
        C0212b.m239a(parcel, 5, dbVar.pX);
        C0212b.m226D(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m572h(x0);
    }

    public db m572h(Parcel parcel) {
        boolean z = false;
        int o = C0211a.m211o(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0211a.m198c(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new db(i3, str, i2, i, z);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m573o(x0);
    }

    public db[] m573o(int i) {
        return new db[i];
    }
}
