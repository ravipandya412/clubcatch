package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.internal.z */
public class C0236z implements Creator<OnContentsResponse> {
    static void m331a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, onContentsResponse.wj);
        C0212b.m234a(parcel, 2, onContentsResponse.CW, i, false);
        C0212b.m226D(parcel, p);
    }

    public OnContentsResponse m332N(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    contents = (Contents) C0211a.m191a(parcel, n, Contents.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnContentsResponse(i, contents);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public OnContentsResponse[] as(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m332N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return as(x0);
    }
}
