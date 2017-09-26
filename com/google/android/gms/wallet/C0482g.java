package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.g */
public class C0482g implements Creator<FullWalletRequest> {
    static void m1382a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, fullWalletRequest.getVersionCode());
        C0212b.m236a(parcel, 2, fullWalletRequest.Yk, false);
        C0212b.m236a(parcel, 3, fullWalletRequest.Yl, false);
        C0212b.m234a(parcel, 4, fullWalletRequest.Yu, i, false);
        C0212b.m226D(parcel, p);
    }

    public FullWalletRequest aX(Parcel parcel) {
        Cart cart = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
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
                    cart = (Cart) C0211a.m191a(parcel, n, Cart.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public FullWalletRequest[] cd(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cd(x0);
    }
}
