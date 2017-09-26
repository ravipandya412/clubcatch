package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.o */
public class C0490o implements Creator<ProxyCard> {
    static void m1390a(ProxyCard proxyCard, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, proxyCard.getVersionCode());
        C0212b.m236a(parcel, 2, proxyCard.Zn, false);
        C0212b.m236a(parcel, 3, proxyCard.Zo, false);
        C0212b.m246c(parcel, 4, proxyCard.Zp);
        C0212b.m246c(parcel, 5, proxyCard.Zq);
        C0212b.m226D(parcel, p);
    }

    public ProxyCard bf(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public ProxyCard[] cl(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cl(x0);
    }
}
