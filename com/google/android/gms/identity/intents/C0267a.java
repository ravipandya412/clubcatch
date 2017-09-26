package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0267a implements Creator<UserAddressRequest> {
    static void m379a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, userAddressRequest.getVersionCode());
        C0212b.m245b(parcel, 2, userAddressRequest.Ky, false);
        C0212b.m226D(parcel, p);
    }

    public UserAddressRequest ar(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    list = C0211a.m197c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddressRequest(i, list);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public UserAddressRequest[] be(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ar(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}
