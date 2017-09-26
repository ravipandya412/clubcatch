package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.GeofenceStatusCodes;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C0240a implements Creator<ComparisonFilter> {
    static void m343a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, comparisonFilter.wj);
        C0212b.m234a(parcel, 1, comparisonFilter.EO, i, false);
        C0212b.m234a(parcel, 2, comparisonFilter.EP, i, false);
        C0212b.m226D(parcel, p);
    }

    public ComparisonFilter[] aH(int i) {
        return new ComparisonFilter[i];
    }

    public ComparisonFilter ac(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) C0211a.m191a(parcel, n, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    metadataBundle2 = (MetadataBundle) C0211a.m191a(parcel, n, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = C0211a.m202g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ac(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aH(x0);
    }
}
