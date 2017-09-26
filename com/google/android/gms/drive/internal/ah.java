package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.location.DetectedActivity;

public class ah implements Creator<OpenFileIntentSenderRequest> {
    static void m274a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, openFileIntentSenderRequest.wj);
        C0212b.m236a(parcel, 2, openFileIntentSenderRequest.CX, false);
        C0212b.m242a(parcel, 3, openFileIntentSenderRequest.Dk, false);
        C0212b.m234a(parcel, 4, openFileIntentSenderRequest.CY, i, false);
        C0212b.m226D(parcel, p);
    }

    public OpenFileIntentSenderRequest m275V(Parcel parcel) {
        DriveId driveId = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
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
                    strArr = C0211a.m221x(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    driveId = (DriveId) C0211a.m191a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public OpenFileIntentSenderRequest[] aA(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m275V(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
