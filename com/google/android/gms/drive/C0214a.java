package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.a */
public class C0214a implements Creator<Contents> {
    static void m249a(Contents contents, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, contents.wj);
        C0212b.m234a(parcel, 2, contents.AC, i, false);
        C0212b.m246c(parcel, 3, contents.CQ);
        C0212b.m246c(parcel, 4, contents.CR);
        C0212b.m234a(parcel, 5, contents.CS, i, false);
        C0212b.m226D(parcel, p);
    }

    public Contents[] ad(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m250y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ad(x0);
    }

    public Contents m250y(Parcel parcel) {
        DriveId driveId = null;
        int i = 0;
        int o = C0211a.m211o(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i3 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0211a.m191a(parcel, n, ParcelFileDescriptor.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    driveId = (DriveId) C0211a.m191a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
