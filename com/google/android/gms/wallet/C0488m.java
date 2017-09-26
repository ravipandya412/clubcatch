package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.m */
public class C0488m implements Creator<NotifyTransactionStatusRequest> {
    static void m1388a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, notifyTransactionStatusRequest.wj);
        C0212b.m236a(parcel, 2, notifyTransactionStatusRequest.Yk, false);
        C0212b.m246c(parcel, 3, notifyTransactionStatusRequest.status);
        C0212b.m236a(parcel, 4, notifyTransactionStatusRequest.Zk, false);
        C0212b.m226D(parcel, p);
    }

    public NotifyTransactionStatusRequest bd(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public NotifyTransactionStatusRequest[] cj(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cj(x0);
    }
}
