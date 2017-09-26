package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;

public class gx implements Creator<gy> {
    static void m947a(gy gyVar, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m245b(parcel, 1, gyVar.fS(), false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, gyVar.getVersionCode());
        C0212b.m226D(parcel, p);
    }

    public gy[] aX(int i) {
        return new gy[i];
    }

    public gy al(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    arrayList = C0211a.m197c(parcel, n, InvitationEntity.CREATOR);
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
            return new gy(i, arrayList);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return al(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aX(x0);
    }
}
