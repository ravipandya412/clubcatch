package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.internal.c */
public class C0242c implements Creator<FilterHolder> {
    static void m345a(FilterHolder filterHolder, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m234a(parcel, 1, filterHolder.ER, i, false);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, filterHolder.wj);
        C0212b.m234a(parcel, 2, filterHolder.ES, i, false);
        C0212b.m234a(parcel, 3, filterHolder.ET, i, false);
        C0212b.m234a(parcel, 4, filterHolder.EU, i, false);
        C0212b.m234a(parcel, 5, filterHolder.EV, i, false);
        C0212b.m226D(parcel, p);
    }

    public FilterHolder[] aJ(int i) {
        return new FilterHolder[i];
    }

    public FilterHolder ae(Parcel parcel) {
        InFilter inFilter = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    comparisonFilter = (ComparisonFilter) C0211a.m191a(parcel, n, ComparisonFilter.CREATOR);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    fieldOnlyFilter = (FieldOnlyFilter) C0211a.m191a(parcel, n, FieldOnlyFilter.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    logicalFilter = (LogicalFilter) C0211a.m191a(parcel, n, LogicalFilter.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    notFilter = (NotFilter) C0211a.m191a(parcel, n, NotFilter.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    inFilter = (InFilter) C0211a.m191a(parcel, n, InFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ae(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aJ(x0);
    }
}
