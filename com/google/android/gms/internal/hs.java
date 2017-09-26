package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationRequest;

public class hs implements Creator<hr> {
    static void m980a(hr hrVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m234a(parcel, 1, hrVar.gu(), i, false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hrVar.wj);
        C0212b.m234a(parcel, 2, hrVar.gv(), i, false);
        C0212b.m226D(parcel, p);
    }

    public hr ay(Parcel parcel) {
        hn hnVar = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        LocationRequest locationRequest = null;
        while (parcel.dataPosition() < o) {
            int i2;
            hn hnVar2;
            LocationRequest locationRequest2;
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = i;
                    LocationRequest locationRequest3 = (LocationRequest) C0211a.m191a(parcel, n, LocationRequest.CREATOR);
                    hnVar2 = hnVar;
                    locationRequest2 = locationRequest3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    hnVar2 = (hn) C0211a.m191a(parcel, n, hn.CREATOR);
                    locationRequest2 = locationRequest;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    hn hnVar3 = hnVar;
                    locationRequest2 = locationRequest;
                    i2 = C0211a.m202g(parcel, n);
                    hnVar2 = hnVar3;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    hnVar2 = hnVar;
                    locationRequest2 = locationRequest;
                    i2 = i;
                    break;
            }
            i = i2;
            locationRequest = locationRequest2;
            hnVar = hnVar2;
        }
        if (parcel.dataPosition() == o) {
            return new hr(i, locationRequest, hnVar);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public hr[] bs(int i) {
        return new hr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ay(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bs(x0);
    }
}
