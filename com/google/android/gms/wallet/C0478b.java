package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C0478b implements Creator<Cart> {
    static void m1378a(Cart cart, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, cart.getVersionCode());
        C0212b.m236a(parcel, 2, cart.Yf, false);
        C0212b.m236a(parcel, 3, cart.Yg, false);
        C0212b.m245b(parcel, 4, cart.Yh, false);
        C0212b.m226D(parcel, p);
    }

    public Cart aT(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                case DetectedActivity.UNKNOWN /*4*/:
                    arrayList = C0211a.m197c(parcel, n, LineItem.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public Cart[] bZ(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bZ(x0);
    }
}
