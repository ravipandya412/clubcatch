package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.drive.internal.g */
public class C0225g implements Creator<CreateFileIntentSenderRequest> {
    static void m292a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, createFileIntentSenderRequest.wj);
        C0212b.m234a(parcel, 2, createFileIntentSenderRequest.Ds, i, false);
        C0212b.m246c(parcel, 3, createFileIntentSenderRequest.CQ);
        C0212b.m236a(parcel, 4, createFileIntentSenderRequest.CX, false);
        C0212b.m234a(parcel, 5, createFileIntentSenderRequest.CY, i, false);
        C0212b.m226D(parcel, p);
    }

    public CreateFileIntentSenderRequest m293H(Parcel parcel) {
        int i = 0;
        DriveId driveId = null;
        int o = C0211a.m211o(parcel);
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    i2 = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    metadataBundle = (MetadataBundle) C0211a.m191a(parcel, n, MetadataBundle.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0211a.m202g(parcel, n);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0211a.m208m(parcel, n);
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
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public CreateFileIntentSenderRequest[] am(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m293H(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return am(x0);
    }
}
