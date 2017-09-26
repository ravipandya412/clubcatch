package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.internal.x */
public class C0235x implements Creator<ListParentsRequest> {
    static void m329a(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, listParentsRequest.wj);
        C0212b.m234a(parcel, 2, listParentsRequest.DT, i, false);
        C0212b.m226D(parcel, p);
    }

    public ListParentsRequest m330M(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    driveId = (DriveId) C0211a.m191a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ListParentsRequest(i, driveId);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public ListParentsRequest[] ar(int i) {
        return new ListParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m330M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ar(x0);
    }
}
