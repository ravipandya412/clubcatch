package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0211a;
import com.google.android.gms.common.internal.safeparcel.C0211a.C0210a;
import com.google.android.gms.common.internal.safeparcel.C0212b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.DetectedActivity;

public class am implements Creator<UpdateMetadataRequest> {
    static void m282a(UpdateMetadataRequest updateMetadataRequest, Parcel parcel, int i) {
        int p = C0212b.m248p(parcel);
        C0212b.m246c(parcel, 1, updateMetadataRequest.wj);
        C0212b.m234a(parcel, 2, updateMetadataRequest.Do, i, false);
        C0212b.m234a(parcel, 3, updateMetadataRequest.Dp, i, false);
        C0212b.m226D(parcel, p);
    }

    public UpdateMetadataRequest m283Z(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C0211a.m211o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int n = C0211a.m209n(parcel);
            switch (C0211a.m189S(n)) {
                case SpinnerCompat.MODE_DROPDOWN /*1*/:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = C0211a.m202g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    g = i;
                    DriveId driveId3 = (DriveId) C0211a.m191a(parcel, n, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case DetectedActivity.STILL /*3*/:
                    metadataBundle2 = (MetadataBundle) C0211a.m191a(parcel, n, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0211a.m195b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new UpdateMetadataRequest(i, driveId, metadataBundle);
        }
        throw new C0210a("Overread allowed size end=" + o, parcel);
    }

    public UpdateMetadataRequest[] aE(int i) {
        return new UpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m283Z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aE(x0);
    }
}
