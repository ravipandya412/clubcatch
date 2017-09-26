package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.f */
public class C0245f implements Creator<LogicalFilter> {
    static void m348a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, logicalFilter.wj);
        C0212b.m234a(parcel, 1, logicalFilter.EO, i, false);
        C0212b.m245b(parcel, 2, logicalFilter.EY, false);
        C0212b.m226D(parcel, p);
    }

    public LogicalFilter[] aL(int i) {
        return new LogicalFilter[i];
    }

    public LogicalFilter ag(Parcel parcel) {
        List list = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            Operator operator2;
            ArrayList c;
            int n = C0211a.m209n(parcel);
            List list2;
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C0211a.m191a(parcel, n, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    c = C0211a.m197c(parcel, n, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    List list3 = list;
                    operator2 = operator;
                    i2 = C0211a.m202g(parcel, n);
                    list2 = list3;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == o) {
            return new LogicalFilter(i, operator, list);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
