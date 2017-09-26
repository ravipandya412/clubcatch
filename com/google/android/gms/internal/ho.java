package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class ho implements Creator<hn> {
    static void m978a(hn hnVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m245b(parcel, 1, hnVar.LA, false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hnVar.wj);
        C0212b.m236a(parcel, 2, hnVar.gr(), false);
        C0212b.m239a(parcel, 3, hnVar.gs());
        C0212b.m226D(parcel, p);
    }

    public hn aw(Parcel parcel) {
        String str = null;
        boolean z = false;
        int o = C0211a.m211o(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    list = C0211a.m197c(parcel, n, ht.CREATOR);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z = C0211a.m198c(parcel, n);
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
            return new hn(i, list, str, z);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public hn[] bq(int i) {
        return new hn[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bq(x0);
    }
}
