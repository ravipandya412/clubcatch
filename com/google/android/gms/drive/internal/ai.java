package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.location.DetectedActivity;

public class ai implements Creator<QueryRequest> {
    static void m276a(QueryRequest queryRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, queryRequest.wj);
        C0212b.m234a(parcel, 2, queryRequest.Ef, i, false);
        C0212b.m226D(parcel, p);
    }

    public QueryRequest m277W(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    query = (Query) C0211a.m191a(parcel, n, Query.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new QueryRequest(i, query);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public QueryRequest[] aB(int i) {
        return new QueryRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m277W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aB(x0);
    }
}
