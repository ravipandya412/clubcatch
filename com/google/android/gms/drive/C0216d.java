package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.d */
public class C0216d implements Creator<DriveId> {
    static void m251a(DriveId driveId, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, driveId.wj);
        C0212b.m236a(parcel, 2, driveId.Dc, false);
        C0212b.m230a(parcel, 3, driveId.Dd);
        C0212b.m230a(parcel, 4, driveId.De);
        C0212b.m226D(parcel, p);
    }

    public DriveId[] ae(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m252z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ae(x0);
    }

    public DriveId m252z(Parcel parcel) {
        long j = 0;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0211a.m208m(parcel, n);
                    break;
                case DetectedActivity.STILL /*3*/:
                    j2 = C0211a.m203h(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    j = C0211a.m203h(parcel, n);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }
}
