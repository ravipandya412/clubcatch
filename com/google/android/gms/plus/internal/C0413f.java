package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.plus.internal.f */
public class C0413f implements Creator<PlusCommonExtras> {
    static void m1207a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, plusCommonExtras.ho(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, plusCommonExtras.getVersionCode());
        C0212b.m236a(parcel, 2, plusCommonExtras.hp(), false);
        C0212b.m226D(parcel, p);
    }

    public PlusCommonExtras aE(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PlusCommonExtras(i, str2, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public PlusCommonExtras[] bB(int i) {
        return new PlusCommonExtras[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bB(x0);
    }
}
