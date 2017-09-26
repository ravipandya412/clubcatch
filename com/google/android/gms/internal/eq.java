package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.internal.ee.C0673a;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class eq implements Creator<C0673a> {
    static void m718a(C0673a c0673a, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, c0673a.getAccountName(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, c0673a.getVersionCode());
        C0212b.m237a(parcel, 2, c0673a.dT(), false);
        C0212b.m246c(parcel, 3, c0673a.dS());
        C0212b.m236a(parcel, 4, c0673a.dV(), false);
        C0212b.m226D(parcel, p);
    }

    public C0673a[] m719R(int i) {
        return new C0673a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m720m(x0);
    }

    public C0673a m720m(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0211a.m211o(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    str2 = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    list = C0211a.m222y(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0211a.m208m(parcel, n);
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
            return new C0673a(i2, str2, list, i, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m719R(x0);
    }
}
