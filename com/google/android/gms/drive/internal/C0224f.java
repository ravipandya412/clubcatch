package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.drive.internal.f */
public class C0224f implements Creator<CreateContentsRequest> {
    static void m290a(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, createContentsRequest.wj);
        C0212b.m226D(parcel, p);
    }

    public CreateContentsRequest m291G(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CreateContentsRequest(i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public CreateContentsRequest[] al(int i) {
        return new CreateContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m291G(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return al(x0);
    }
}
