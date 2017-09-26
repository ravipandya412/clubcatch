package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;

public class ie implements Creator<id> {
    static void m987a(id idVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m236a(parcel, 1, idVar.OG, false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, idVar.versionCode);
        C0212b.m236a(parcel, 2, idVar.OH, false);
        C0212b.m226D(parcel, p);
    }

    public id aD(Parcel parcel) {
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
            return new id(i, str2, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public id[] by(int i) {
        return new id[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return by(x0);
    }
}
