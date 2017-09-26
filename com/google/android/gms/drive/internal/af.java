package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.DetectedActivity;

public class af implements Creator<OnMetadataResponse> {
    static void m270a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, onMetadataResponse.wj);
        C0212b.m234a(parcel, 2, onMetadataResponse.Ds, i, false);
        C0212b.m226D(parcel, p);
    }

    public OnMetadataResponse m271T(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    metadataBundle = (MetadataBundle) C0211a.m191a(parcel, n, MetadataBundle.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public OnMetadataResponse[] ay(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m271T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ay(x0);
    }
}
