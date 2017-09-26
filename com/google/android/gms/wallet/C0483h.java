package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.h */
public class C0483h implements Creator<InstrumentInfo> {
    static void m1383a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, instrumentInfo.getVersionCode());
        C0212b.m236a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        C0212b.m236a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        C0212b.m226D(parcel, p);
    }

    public InstrumentInfo aY(Parcel parcel) {
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
            return new InstrumentInfo(i, str2, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public InstrumentInfo[] ce(int i) {
        return new InstrumentInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ce(x0);
    }
}
