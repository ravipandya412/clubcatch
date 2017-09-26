package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.e */
public class C0480e implements Creator<C0874d> {
    static void m1380a(C0874d c0874d, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, c0874d.getVersionCode());
        C0212b.m234a(parcel, 2, c0874d.Yj, i, false);
        C0212b.m226D(parcel, p);
    }

    public C0874d aV(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    loyaltyWalletObject = (LoyaltyWalletObject) C0211a.m191a(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0874d(i, loyaltyWalletObject);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0874d[] cb(int i) {
        return new C0874d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cb(x0);
    }
}
