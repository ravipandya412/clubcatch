package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0239a implements Creator<Query> {
    static void m342a(Query query, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, query.wj);
        C0212b.m234a(parcel, 1, query.EL, i, false);
        C0212b.m236a(parcel, 3, query.EM, false);
        C0212b.m226D(parcel, p);
    }

    public Query[] aG(int i) {
        return new Query[i];
    }

    public Query ab(Parcel parcel) {
        String str = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < o) {
            int i2;
            String str2;
            LogicalFilter logicalFilter2;
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = i;
                    LogicalFilter logicalFilter3 = (LogicalFilter) C0211a.m191a(parcel, n, LogicalFilter.CREATOR);
                    str2 = str;
                    logicalFilter2 = logicalFilter3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0211a.m208m(parcel, n);
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    String str3 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = C0211a.m202g(parcel, n);
                    str2 = str3;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
            }
            i = i2;
            logicalFilter = logicalFilter2;
            str = str2;
        }
        if (parcel.dataPosition() == o) {
            return new Query(i, logicalFilter, str);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ab(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
