package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0223e implements Creator<CloseContentsRequest> {
    static void m288a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, closeContentsRequest.wj);
        C0212b.m234a(parcel, 2, closeContentsRequest.Dq, i, false);
        C0212b.m235a(parcel, 3, closeContentsRequest.Dr, false);
        C0212b.m226D(parcel, p);
    }

    public CloseContentsRequest m289F(Parcel parcel) {
        Boolean bool = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            Contents contents2;
            int g;
            Boolean bool2;
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = C0211a.m202g(parcel, n);
                    bool2 = bool3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    g = i;
                    Contents contents3 = (Contents) C0211a.m191a(parcel, n, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    bool2 = C0211a.m199d(parcel, n);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == o) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public CloseContentsRequest[] ak(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m289F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ak(x0);
    }
}
