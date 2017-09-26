package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;

/* renamed from: com.google.android.gms.location.c */
public class C0369c implements Creator<C0742b> {
    static void m1118a(C0742b c0742b, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, c0742b.Lh);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0742b.getVersionCode());
        C0212b.m246c(parcel, 2, c0742b.Li);
        C0212b.m230a(parcel, 3, c0742b.Lj);
        C0212b.m226D(parcel, p);
    }

    public C0742b au(Parcel parcel) {
        int i = 1;
        int o = C0211a.m211o(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0742b(i2, i3, i, j);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public C0742b[] bm(int i) {
        return new C0742b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return au(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bm(x0);
    }
}
