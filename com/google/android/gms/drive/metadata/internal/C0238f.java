package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.metadata.internal.f */
public class C0238f implements Creator<MetadataBundle> {
    static void m341a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, metadataBundle.wj);
        C0212b.m231a(parcel, 2, metadataBundle.Ek, false);
        C0212b.m226D(parcel, p);
    }

    public MetadataBundle[] aF(int i) {
        return new MetadataBundle[i];
    }

    public MetadataBundle aa(Parcel parcel) {
        int o = C0211a.m211o(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    bundle = C0211a.m212o(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aF(x0);
    }
}
