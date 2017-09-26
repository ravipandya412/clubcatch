package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

public class aa implements Creator<OnDownloadProgressResponse> {
    static void m260a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, onDownloadProgressResponse.wj);
        C0212b.m230a(parcel, 2, onDownloadProgressResponse.DZ);
        C0212b.m230a(parcel, 3, onDownloadProgressResponse.Ea);
        C0212b.m226D(parcel, p);
    }

    public OnDownloadProgressResponse m261O(Parcel parcel) {
        long j = 0;
        int o = C0211a.m211o(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public OnDownloadProgressResponse[] at(int i) {
        return new OnDownloadProgressResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m261O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return at(x0);
    }
}
