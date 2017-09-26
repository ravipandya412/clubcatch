package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;

public class ag implements Creator<OpenContentsRequest> {
    static void m272a(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, openContentsRequest.wj);
        C0212b.m234a(parcel, 2, openContentsRequest.Do, i, false);
        C0212b.m246c(parcel, 3, openContentsRequest.CR);
        C0212b.m226D(parcel, p);
    }

    public OpenContentsRequest m273U(Parcel parcel) {
        int i = 0;
        int o = C0211a.m211o(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    int i3 = i;
                    driveId2 = driveId;
                    g = C0211a.m202g(parcel, n);
                    n = i3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    g = i2;
                    DriveId driveId3 = (DriveId) C0211a.m191a(parcel, n, DriveId.CREATOR);
                    n = i;
                    driveId2 = driveId3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    n = C0211a.m202g(parcel, n);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    n = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new OpenContentsRequest(i2, driveId, i);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public OpenContentsRequest[] az(int i) {
        return new OpenContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m273U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return az(x0);
    }
}
